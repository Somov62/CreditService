package com.SberTech.CreditService.Entities;

import com.SberTech.CreditService.Entities.Participants.Participant;
import com.SberTech.CreditService.Entities.Pledges.BasePledge;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;
import java.util.List;

@Entity
@DynamicUpdate
@Table (name = "credit_deal")
public class CreditDeal {

    public CreditDeal() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deal")
    private List<CreditCondition> conditions;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deal")
    private List<BasePledge> pledges;
    @ManyToMany
    @Cascade({
            org.hibernate.annotations.CascadeType.SAVE_UPDATE,
            org.hibernate.annotations.CascadeType.MERGE,
            org.hibernate.annotations.CascadeType.PERSIST})
    @JoinTable (
            name = "deal_participant",
            joinColumns = @JoinColumn(name = "deal_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_id")
    )
    private List<Participant> participants;

    @Version
    private long version;

    public long getVersion() {
        return version;
    }
    public void setVersion(long version) {
        this.version = version;
    }
    public List<BasePledge> getPledges() {
        return pledges;
    }

    public void setPledges(List<BasePledge> pledges) {
        this.pledges = pledges;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
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

    public List<CreditCondition> getConditions() {
        return conditions;
    }

    public void setConditions(List<CreditCondition> conditions) {
        this.conditions = conditions;
    }
}
