package com.SberTech.CreditService.CreditDealDatabase.Entities.Participants;

import com.SberTech.CreditService.CreditDealDatabase.Entities.CreditDeal;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, defaultImpl = NaturalPerson.class)
@JsonSubTypes({
        @JsonSubTypes.Type(NaturalPerson.class),
        @JsonSubTypes.Type(IndividualBusinessman.class),
        @JsonSubTypes.Type(Company.class)})
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long inn;
    private boolean isBorrower;
    private boolean isGuarantor;
    private boolean isPledger;

    @ManyToMany(
            mappedBy = "participants",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    private List<CreditDeal> deals;

    public Participant() {
    }

    public List<CreditDeal> getDeals() {
        return deals;
    }

    public void setDeals(List<CreditDeal> deals) {
        this.deals = deals;
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

    public long getInn() {
        return inn;
    }

    public void setInn(long inn) {
        this.inn = inn;
    }

    public boolean isBorrower() {
        return isBorrower;
    }

    public void setBorrower(boolean borrower) {
        isBorrower = borrower;
    }

    public boolean isGuarantor() {
        return isGuarantor;
    }

    public void setGuarantor(boolean guarantor) {
        isGuarantor = guarantor;
    }

    public boolean isPledger() {
        return isPledger;
    }

    public void setPledger(boolean pledger) {
        isPledger = pledger;
    }
}
