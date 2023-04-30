package com.SberTech.CreditService.Audit.Services;

import com.SberTech.CreditService.Audit.Database.AuditRepo;
import com.SberTech.CreditService.Audit.Database.Enitities.AuditEntity;
import com.SberTech.CreditService.Audit.Database.Enitities.FieldChangeModel;
import com.SberTech.CreditService.Audit.Database.Enitities.StateType;
import com.SberTech.CreditService.Audit.Database.Enitities.Version;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AuditService {

    @Autowired
    private AuditRepo repo;

    @Autowired
    private ObjectComparer comparer;

    public void auditSave(Object newEntity) {
        String name = newEntity.getClass().getSimpleName();
        String primaryKey = this.getPrimaryKey(newEntity);
        //Если сущность не найдена, значит ее добавили, а если найдена, то изменили
        var records = repo.findByNameAndPrimaryKey(name, primaryKey);
        if (records.isEmpty()) {
            auditAdd(newEntity);
            return;
        }
        AuditEntity record = records.get(0);
        auditEdit(newEntity, record);
    }



    public void auditAdd(Object newEntity) {
        //Создаем новую аудит сущность
        AuditEntity entity = new AuditEntity();
        entity.setName(newEntity.getClass().getSimpleName()); // Заполняем имя класса
        entity.setPrimaryKey(this.getPrimaryKey(newEntity));  // Заполняем первичный ключ
        entity.setMode(StateType.CREATED);
        entity.setFullVersion(this.serialize(newEntity));

        Version version = new Version();
        version.setVersion(1);
        //Сравниваем новый объект с null, чтобы зафиксировать всю сущность сразу
        List<FieldChangeModel> changeList = comparer.Compare(Optional.empty(), newEntity);
        version.setChanges(serialize(changeList));
        entity.setVersions(new ArrayList<>());
        entity.getVersions().add(version);
        repo.save(entity);
    }


    public void auditEdit(Object newEntity, AuditEntity record){

        record.setMode(StateType.MODIFIED);
        //Создаем новую версию
        Version version = new Version();
        version.setVersion(record.getVersions().size() + 1);
        //Получаем старую версию сущности из json
        Object oldEntity = this.deserialize(record.getFullVersion(), newEntity.getClass());
        //Сохраняем новую версию в json
        record.setFullVersion(this.serialize(newEntity));
        //Сравниваем новый объект со старым
        List<FieldChangeModel> changeList = comparer.Compare(Optional.ofNullable(oldEntity), newEntity);
        version.setChanges(serialize(changeList)); //Сохраняем измения в json формате
        record.getVersions().add(version);
        repo.save(record);
    }

    public void auditDelete(Object newEntity) {

        String name = newEntity.getClass().getSimpleName();
        String primaryKey = this.getPrimaryKey(newEntity);
        //Получаем аудит сущность, сопоставляя имя класса и первичных ключ
        var records = repo.findByNameAndPrimaryKey(name, primaryKey);
        if (records.isEmpty()) {
            return;
        }
        AuditEntity record = records.get(0);

        record.setMode(StateType.DELETED);

        Version version = new Version();
        version.setVersion(record.getVersions().size() + 1);
        version.setChanges("entity deleted");
        record.getVersions().add(version);
        repo.save(record);
    }




    private String getPrimaryKey(Object entity) {
        final Field[] fields = entity.getClass().getDeclaredFields();
        for (final Field field : fields) {
            if (field.isAnnotationPresent(Id.class)) {
                try {
                    field.setAccessible(true);
                    return field.get(entity).toString();
                } catch (IllegalAccessException ignored) {}
            }
        }
        return null;
    }

    private String serialize(Object content) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(content);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    private Object deserialize(String json, Class targetType) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, targetType.getClass());
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}