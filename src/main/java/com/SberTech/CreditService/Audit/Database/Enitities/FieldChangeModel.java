package com.SberTech.CreditService.Audit.Database.Enitities;

/**
 * Структурная единица фиксирования изменений
 * Импользуется для удобной записи в json
 */
public class FieldChangeModel {
    public String field;
    public Object newValue;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getNewValue() {
        return newValue;
    }

    public void setNewValue(Object newValue) {
        this.newValue = newValue;
    }
}
