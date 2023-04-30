package com.SberTech.CreditService.CreditDealDatabase.Entities.Pledges;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, defaultImpl = LandPledge.class)
@JsonSubTypes({
        @JsonSubTypes.Type(LandPledge.class),
        @JsonSubTypes.Type(CarPledge.class),
        @JsonSubTypes.Type(FlatPledge.class)})
public class BasePledge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    protected String name;

    @Column(name = "amount")
    protected BigDecimal amount;

    public BasePledge() {
    }


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
