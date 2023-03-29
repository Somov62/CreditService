package com.SberTech.CreditService.Models;

import com.SberTech.CreditService.Models.Participants.ParticipantDto;
import com.SberTech.CreditService.Models.Pledges.BasePledgeDto;

import java.util.Date;
import java.util.List;

public class CreditDealDto {
    private long id;
    private Date creationDate;
    private List<CreditConditionDto> creditConditions;
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

    public List<CreditConditionDto> getCreditConditions() {
        return creditConditions;
    }

    public void setCreditConditions(List<CreditConditionDto> creditConditions) {
        this.creditConditions = creditConditions;
    }
}
