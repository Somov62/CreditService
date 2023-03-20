package com.SberTech.CreditService.Entities;

import com.SberTech.CreditService.Entities.Pledges.BasePledge;
import com.SberTech.CreditService.Models.CreditConditionType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "credit_deal")
public class CreditDeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "credit_condition")
    @Enumerated(EnumType.ORDINAL)
    private CreditConditionType creditCondition;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "period")
    private int period; //in months

    @Column(name = "interest_rate")
    private double interestRate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dealId")
    private List<BasePledge> pledges;

    public List<BasePledge> getPledges() {
        return pledges;
    }

    public void setPledges(List<BasePledge> pledges) {
        this.pledges = pledges;
    }

    public List<BasePledge> getParticipants() {
        return participants;
    }

    public void setParticipants(List<BasePledge> participants) {
        this.participants = participants;
    }

    @ManyToMany(mappedBy = "deals")
    private List<BasePledge> participants;
    public CreditDeal() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public CreditConditionType getCreditCondition() {
        return creditCondition;
    }

    public void setCreditCondition(CreditConditionType creditCondition) {
        this.creditCondition = creditCondition;
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
