package com.SberTech.CreditService.Dto.Pledges;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.math.BigDecimal;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, defaultImpl = LandPledgeDto.class)
@JsonSubTypes({
        @JsonSubTypes.Type(LandPledgeDto.class),
        @JsonSubTypes.Type(CarPledgeDto.class),
        @JsonSubTypes.Type(FlatPledgeDto.class)})
public class BasePledgeDto {

    public BasePledgeDto() {
    }
    private long id;
    private String name;

    private BigDecimal amount;

    //getters and setters area

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
