package com.SberTech.CreditService.Dto;

import com.SberTech.CreditService.Dto.Enums.CreditConditionType;

import java.math.BigDecimal;

public class CreditConditionDto {
    private long id;
    private CreditConditionType creditConditionType;
    private BigDecimal amount;
    private int period; //in months
    private double interestRate;

    public CreditConditionDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CreditConditionType getCreditConditionType() {
        return creditConditionType;
    }

    public void setCreditConditionType(CreditConditionType creditConditionType) {
        this.creditConditionType = creditConditionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
