package com.SberTech.CreditService.Models;

import com.SberTech.CreditService.Models.Enums.CreditConditionType;
import com.SberTech.CreditService.Models.Participants.ParticipantDto;
import com.SberTech.CreditService.Models.Pledges.BasePledgeDto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CreditDealDto {
    private long id;
    private Date creationDate;
    private CreditConditionType creditCondition;
    private BigDecimal amount;
    private int period; //in months
    private double interestRate;
    private List<BasePledgeDto> pledges;
    private List<ParticipantDto> participants;
    private long version;

    public CreditDealDto() {
    }

    //getters and setters area
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

    public List<BasePledgeDto> getPledges() {
        return pledges;
    }

    public void setPledges(List<BasePledgeDto> pledges) {
        this.pledges = pledges;
    }

    public List<ParticipantDto> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantDto> participants) {
        this.participants = participants;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
