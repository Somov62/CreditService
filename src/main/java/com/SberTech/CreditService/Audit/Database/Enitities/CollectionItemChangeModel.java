package com.SberTech.CreditService.Audit.Database.Enitities;

/**
 * Структурная единица фиксирования изменений в связанной коллеуии
 * Импользуется для удобной записи в json
 * Хранит первичный ключи сущности, список изменений и статус сущности
 */
public class CollectionItemChangeModel {
    private String id;
    private Object changes;
    private  StateType state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getChanges() {
        return changes;
    }

    public void setChanges(Object changes) {
        this.changes = changes;
    }

    public StateType getState() {
        return state;
    }

    public void setState(StateType state) {
        this.state = state;
    }
}
