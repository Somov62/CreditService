package com.SberTech.CreditService.Models;

import com.SberTech.CreditService.Entities.CreditDeal;
import com.SberTech.CreditService.Entities.Participants.Company;
import com.SberTech.CreditService.Entities.Participants.IndividualBusinessman;
import com.SberTech.CreditService.Entities.Participants.NaturalPerson;
import com.SberTech.CreditService.Entities.Pledges.BasePledge;
import com.SberTech.CreditService.Models.Enums.CreditConditionType;
import com.SberTech.CreditService.Models.Participants.BaseParticipantModel;
import com.SberTech.CreditService.Models.Participants.CompanyModel;
import com.SberTech.CreditService.Models.Participants.IndividualBusinessmanModel;
import com.SberTech.CreditService.Models.Participants.NaturalPersonModel;
import com.SberTech.CreditService.Models.Pledges.BasePledgeModel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CreditDealModel {

    public CreditDealModel() {
    }

    public CreditDealModel(CreditDeal entity) {
        this.id = entity.getId();
        this.creationDate = entity.getCreationDate();
        this.creditCondition = entity.getCreditCondition();
        this.amount = entity.getAmount();
        this.period = entity.getPeriod();
        this.interestRate = entity.getInterestRate();
        this.pledges = entity.getPledges().stream().map(BasePledge::convertToDto).toList();
        //Связанный список участников сделки
        this.participants = entity.getParticipants().stream().map(
                e -> {
                    //Сопоставление по типу участника
                    if (e.getClass() == IndividualBusinessman.class)
                            return new IndividualBusinessmanModel((IndividualBusinessman)e);
                    if (e.getClass() == Company.class)
                            return new CompanyModel((Company) e);
                    return new NaturalPersonModel((NaturalPerson)e);
                }).toList();
    }
    private long id;
    private Date creationDate;
    private CreditConditionType creditCondition;
    private BigDecimal amount;
    private int period; //in months
    private double interestRate;
    private List<BasePledgeModel> pledges;
    private List<BaseParticipantModel> participants;


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

    public List<BasePledgeModel> getPledges() {
        return pledges;
    }

    public void setPledges(List<BasePledgeModel> pledges) {
        this.pledges = pledges;
    }

    public List<BaseParticipantModel> getParticipants() {
        return participants;
    }

    public void setParticipants(List<BaseParticipantModel> participants) {
        this.participants = participants;
    }
}
