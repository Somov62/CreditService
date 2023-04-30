package com.SberTech.CreditService.Audit.Services;

import com.SberTech.CreditService.Audit.Database.Enitities.CollectionItemChangeModel;
import com.SberTech.CreditService.Audit.Database.Enitities.FieldChangeModel;
import com.SberTech.CreditService.Audit.Database.Enitities.StateType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import org.hibernate.collection.spi.PersistentBag;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;

@Service
public class ObjectComparer {

    public  List<FieldChangeModel> Compare(Optional<Object> firstState, Object secondState) {
        //Первый объект может быть null, а вот второй нет.
        // Такой случай используется, когда аудируемая сущность только создана и ни разу не модифицирована
        if (secondState == null)
            throw new IllegalArgumentException("secondState shouldn't be null");

        //Список измененных полей.
        List<FieldChangeModel> changedProperties = new ArrayList<>();

        //Получаем из класса все поля и пробегаемся по ним
        for (Field field : secondState.getClass().getDeclaredFields()) {
            // Меняем модификатор доступа, чтобы получить значение свойства
            field.setAccessible(true);
            Object value1 = null;
            Object value2 = null;
            try {
                if (firstState.isPresent()) {
                    value1 = field.get(firstState.get()); //получаем значение поля первого объекта
                }
                value2 = field.get(secondState); //получаем значение поля второго объекта
            } catch (IllegalAccessException e) {
                continue;
            }
            if (value1 == null && value2 == null)
                continue;

            FieldChangeModel model = new FieldChangeModel();

            //Если поле представляет собой коллекцию, то обрабатываем этот сценарий отдельно
            if (Collection.class.isAssignableFrom(field.getType())) {
                //Пропускаем ManytoOne коллекции, чтобы избежать циклических зависимостей
                if (field.isAnnotationPresent(ManyToOne.class))
                    continue;
                //Пропускаем коллекции без аннотации JoinColumn, чтобы избежать циклических зависимостей
                if (!field.isAnnotationPresent(JoinColumn.class))
                    continue;
                //Измения в коллекции ищет метод compareCollections
                model.newValue = this.compareCollections(value1, value2);
            }
            //При
            if (field.isAnnotationPresent(OneToOne.class)) {
                //Избавляемся от циклических зависимочтей в OneToOne связях
                var annotation =  field.getAnnotation(OneToOne.class);
                if (annotation.mappedBy() == null)
                    continue;
                model.newValue = this.Compare(Optional.ofNullable(value1), value2);

            }

            //Во всех остальных случаях, будем считать объект примитивным и искать изменения методом comparePrimitive
            if (!Collection.class.isAssignableFrom(field.getType()) && !field.isAnnotationPresent(OneToOne.class))
                model.newValue = comparePrimitive(value1, value2);

            //Если model.newValue = null, значит изменений не обнаружено, и старая версия поля соответсвует новой.
            if (model.newValue == null)
                continue;
            //Заполняем имя и добавляем в коллекцию
            model.field = field.getName();
            changedProperties.add(model);
        }
        if (changedProperties.isEmpty())
            return null;
        return changedProperties;
    }

    private String comparePrimitive(Object firstValue, Object secondValue) {
        if (!Objects.equals(firstValue, secondValue)) {
            if (secondValue != null)
                return secondValue.toString();
            return "null"; //null в строке покрывает случай, когда в новой версии значение поля установлено в null
        }
        return null;
    }

    private List<CollectionItemChangeModel> compareCollections(Object firstValue, Object secondValue) {
        List<CollectionItemChangeModel> collectionChanges = new ArrayList<>();

        //Каст значений поля в списки. Возможно два изначальных типа: АrrayList и PersistentBag
        List collectionFirst = (firstValue instanceof ArrayList ? new ArrayList((ArrayList) firstValue) : firstValue instanceof PersistentBag ? new ArrayList((List) firstValue) : null);
        List collectionSecond = (secondValue instanceof ArrayList ? new ArrayList((List) secondValue) : secondValue instanceof PersistentBag ? new ArrayList((List) secondValue) : null);

        if (collectionFirst != null && collectionSecond != null) {
            for (int i = 0; i < collectionFirst.size(); i++) {
                var pk1 = getPrimaryKey(collectionFirst.get(i));

                for (int j = 0; j < collectionSecond.size(); j++) {
                    //Если первичные ключи элементов в обоих коллекциях совпали, значит это одна и та же сущность
                    if (Objects.equals(pk1, getPrimaryKey(collectionSecond.get(j)))) {
                        //Ищем изменения между этими двуми жлементами
                        var changes = this.Compare(Optional.of(collectionFirst.get(i)), collectionSecond.get(j));
                        //Если изменения найдены, то фиксируем их
                        if (changes != null) {
                            var model = new CollectionItemChangeModel();
                            model.setId(pk1);
                            model.setState(StateType.MODIFIED);
                            model.setChanges(changes);
                            collectionChanges.add(model);
                        }
                        //Удаляем пару из колекций
                        collectionFirst.remove(i);
                        collectionSecond.remove(j);
                        i--;
                        j--;
                        break;
                    }
                }
            }

        }

        if (collectionFirst != null) {
            //Оставшиеся элементы первой коллекции не нашли себе пару во второй. Значит из второй их удалили.
            for (int i = 0; i < collectionFirst.size(); i++) {
                var pk = getPrimaryKey(collectionFirst.get(i));

                //Фиксируем элемент коллекции, как удаленный
                var model = new CollectionItemChangeModel();
                model.setId(pk);
                model.setState(StateType.DELETED);
                model.setChanges(null);
                collectionChanges.add(model);
            }
        }
        //Оставшиеся элементы второй коллекции не нашли себе пару в первой. Значит это добавленные сущности
        if (collectionSecond != null) {
            for (int i = 0; i < collectionSecond.size(); i++) {
                var pk = getPrimaryKey(collectionSecond.get(i));
                var changes = this.Compare(Optional.empty(), collectionSecond.get(i));
                var model = new CollectionItemChangeModel();
                model.setId(pk);
                model.setState(StateType.CREATED);
                model.setChanges(changes);
                collectionChanges.add(model);
            }
        }
        if (collectionChanges.isEmpty())
            return null;
        return collectionChanges;
    }

    private String getPrimaryKey(Object entity) {
        final Field[] fields = entity.getClass().getDeclaredFields();
        for (final Field field : fields) {
            if (field.isAnnotationPresent(Id.class)) {
                try {
                    field.setAccessible(true);
                    return field.get(entity).toString();
                } catch (IllegalAccessException ignored) {
                }
            }
        }
        return null;
    }
}
