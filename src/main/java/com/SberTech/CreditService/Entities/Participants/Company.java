package com.SberTech.CreditService.Entities.Participants;

import com.SberTech.CreditService.Models.GenderType;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Company {

    private String name;

    @Enumerated(EnumType.ORDINAL)
    private GenderType gender;

    private long ogrn;

    @Column(name = "registration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    private String registration_address;
    private String residential_address;

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public long getOgrn() {
        return ogrn;
    }

    public void setOgrn(long ogrn) {
        this.ogrn = ogrn;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getRegistration_address() {
        return registration_address;
    }

    public void setRegistration_address(String registration_address) {
        this.registration_address = registration_address;
    }

    public String getResidential_address() {
        return residential_address;
    }

    public void setResidential_address(String residential_address) {
        this.residential_address = residential_address;
    }
}
