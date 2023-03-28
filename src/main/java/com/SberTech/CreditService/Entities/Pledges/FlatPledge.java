package com.SberTech.CreditService.Entities.Pledges;

import jakarta.persistence.Entity;

@Entity
public class FlatPledge extends BasePledge {

    private String address;
    private double totalArea;
    private int floor;
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

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getCadastralNumber() {
        return cadastralNumber;
    }

    public void setCadastralNumber(String cadastralNumber) {
        this.cadastralNumber = cadastralNumber;
    }


    public FlatPledge() {
    }
}
