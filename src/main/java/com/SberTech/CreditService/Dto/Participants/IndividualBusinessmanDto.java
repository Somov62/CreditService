package com.SberTech.CreditService.Dto.Participants;

import com.SberTech.CreditService.Dto.Enums.GenderType;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class IndividualBusinessmanDto extends ParticipantDto {
    private String firstName;
    private String lastName;
    private String middleName;
    private GenderType gender;
    private int passportSerial;
    private int passportNumber;
    private long ogrn;
    private Date registrationDate;
    private String registration_address;
    private String residential_address;

    public IndividualBusinessmanDto() {
    }

    @JsonCreator
    public IndividualBusinessmanDto(@JsonProperty(value = "ogrn", required = true) long x) {
        this.ogrn = x;
    }

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public int getPassportSerial() {
        return passportSerial;
    }

    public void setPassportSerial(int passportSerial) {
        this.passportSerial = passportSerial;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
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
