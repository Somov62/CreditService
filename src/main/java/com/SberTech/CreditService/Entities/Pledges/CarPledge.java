package com.SberTech.CreditService.Entities.Pledges;

import com.SberTech.CreditService.Models.Pledges.BasePledgeModel;
import com.SberTech.CreditService.Models.Pledges.CarPledgeModel;
import jakarta.persistence.Entity;

@Entity
public class CarPledge extends BasePledge {

    private String brand;
    private String model;
    private String vin;
    private String registrationNumber;
    private double power;
    private int releaseYear;

    public CarPledge() {
    }

    @Override
    public BasePledgeModel convertToDto() {
        CarPledgeModel model = new CarPledgeModel();
        model.setId(this.id);
        model.setName(this.name);
        model.setAmount(this.amount);
        model.setBrand(this.brand);
        model.setModel(this.model);
        model.setVin(this.vin);
        model.setPower(this.power);
        model.setReleaseYear(this.releaseYear);
        return model;
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
