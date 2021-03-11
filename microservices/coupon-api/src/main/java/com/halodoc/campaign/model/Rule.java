package com.halodoc.campaign.model;

import java.util.List;

public class Rule {

    private String id;

    private List<Item> items;
    private List<Location> locations;
    private double purchaseAmount;
    private double limitAmount;
    private int limitRepeat;
    private RedemptionType redemptionType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public double getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(double limitAmount) {
        this.limitAmount = limitAmount;
    }

    public int getLimitRepeat() {
        return limitRepeat;
    }

    public void setLimitRepeat(int limitRepeat) {
        this.limitRepeat = limitRepeat;
    }

    public RedemptionType getRedemptionType() {
        return redemptionType;
    }

    public void setRedemptionType(RedemptionType redemptionType) {
        this.redemptionType = redemptionType;
    }
}
