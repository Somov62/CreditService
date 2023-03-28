package com.SberTech.CreditService.Entities.Pledges;

import com.SberTech.CreditService.Entities.CreditDeal;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public class BasePledge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @ManyToOne
    @JoinColumn(name = "deal_id")
    protected CreditDeal deal;

    protected String name;

    @Column(name = "amount")
    protected BigDecimal amount;

    public BasePledge() {
    }

    public CreditDeal getDeal() {
        return deal;
    }

    public void setDealId(CreditDeal deal) {
        this.deal = deal;
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
