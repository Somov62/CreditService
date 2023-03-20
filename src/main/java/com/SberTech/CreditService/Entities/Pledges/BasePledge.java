package com.SberTech.CreditService.Entities.Pledges;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public class BasePledge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name ="deal_id")
    private long dealId;

    private String name;

    @Column(name = "amount")
    private BigDecimal amount;

    public BasePledge() {
    }

    public long getDealId() {
        return dealId;
    }

    public void setDealId(long dealId) {
        this.dealId = dealId;
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
