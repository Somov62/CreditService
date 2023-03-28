package com.SberTech.CreditService.Entities.Pledges;

import jakarta.persistence.Entity;

@Entity
public class LandPledge extends BasePledge {

    public LandPledge() {
    }
    private String address;
    private double totalArea;
    private String cadastralNumber;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }

    public String getCadastralNumber() {
        return cadastralNumber;
    }

    public void setCadastralNumber(String cadastralNumber) {
        this.cadastralNumber = cadastralNumber;
    }
}
