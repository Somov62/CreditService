package com.SberTech.CreditService.Models.Pledges;

public class LandPledgeModel extends BasePledgeModel {

    public LandPledgeModel() {
    }

    private String address;
    private double totalArea;
    private String cadastralNumber;

    //getters and setters area

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
