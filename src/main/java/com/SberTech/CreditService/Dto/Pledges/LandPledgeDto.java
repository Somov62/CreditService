package com.SberTech.CreditService.Dto.Pledges;

public class LandPledgeDto extends BasePledgeDto {
    private String address;
    private double totalArea;
    private String cadastralNumber;

    public LandPledgeDto() {
    }

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
