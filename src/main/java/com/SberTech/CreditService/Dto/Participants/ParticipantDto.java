package com.SberTech.CreditService.Dto.Participants;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, defaultImpl = NaturalPersonDto.class)
@JsonSubTypes({
        @JsonSubTypes.Type(NaturalPersonDto.class),
        @JsonSubTypes.Type(IndividualBusinessmanDto.class),
        @JsonSubTypes.Type(CompanyDto.class)})
public class ParticipantDto {

    protected long id;
    protected String name;
    protected long inn;
    protected boolean isBorrower;
    protected boolean isGuarantor;
    protected boolean isPledger;

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
