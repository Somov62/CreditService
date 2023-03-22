package com.SberTech.CreditService.Models.Participants;

import com.SberTech.CreditService.Entities.Participants.Company;

import java.util.Date;

public class CompanyModel extends BaseParticipantModel {

    public CompanyModel() {
    }

    public CompanyModel(Company entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.inn = entity.getInn();
        this.isBorrower = entity.isBorrower();
        this.isGuarantor = entity.isGuarantor();
        this.isPledger = entity.isPledger();
        this.companyName = entity.getCompanyName();
        this.ogrn = entity.getOgrn();
        this.registration_address = entity.getRegistration_address();
        this.registrationDate = entity.getRegistrationDate();
        this.residential_address = entity.getResidential_address();
    }

    private String companyName;
    private long ogrn;
    private Date registrationDate;
    private String registration_address;
    private String residential_address;

    //getters and setters area

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
