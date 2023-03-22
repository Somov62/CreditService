package com.SberTech.CreditService.Entities.Pledges;

import com.SberTech.CreditService.Models.Pledges.BasePledgeModel;
import com.SberTech.CreditService.Models.Pledges.LandPledgeModel;
import jakarta.persistence.Entity;

@Entity
public class LandPledge extends BasePledge {

    public LandPledge() {
    }
    private String address;
    private double totalArea;
    private String cadastralNumber;

    @Override
    public BasePledgeModel convertToDto() {
        LandPledgeModel model = new LandPledgeModel();
        model.setId(this.id);
        model.setName(this.name);
        model.setAmount(this.amount);
        model.setAddress(this.address);
        model.setCadastralNumber(this.cadastralNumber);
        model.setTotalArea(this.totalArea);
        return model;
    }

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
