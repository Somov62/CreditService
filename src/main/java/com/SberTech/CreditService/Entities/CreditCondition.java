package com.SberTech.CreditService.Entities;

import com.SberTech.CreditService.Models.Enums.CreditConditionType;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "credit_condition")
public class CreditCondition {

    public CreditCondition() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "deal_id")
    protected CreditDeal deal;

    @Column(name = "credit_condition_type")
    @Enumerated(EnumType.ORDINAL)
    private CreditConditionType creditConditionType;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "period")
    private int period; //in months

    @Column(name = "interest_rate")
    private double interestRate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CreditDeal getDeal() {
        return deal;
    }

    public void setDeal(CreditDeal deal) {
        this.deal = deal;
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
