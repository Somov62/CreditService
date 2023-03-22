package com.SberTech.CreditService.Models.Pledges;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.math.BigDecimal;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, defaultImpl = LandPledgeModel.class)
@JsonSubTypes({
        @JsonSubTypes.Type(LandPledgeModel.class),
        @JsonSubTypes.Type(CarPledgeModel.class),
        @JsonSubTypes.Type(FlatPledgeModel.class)})
public class BasePledgeModel {

    public BasePledgeModel() {
    }
    private long id;
    private String name;

    private BigDecimal amount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
