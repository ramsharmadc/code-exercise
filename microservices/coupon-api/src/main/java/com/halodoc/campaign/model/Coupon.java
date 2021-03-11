package com.halodoc.campaign.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Coupon {

    private String id;
    private List<Item> items;
    private double amount;
    private String category;
    private Date validity;
    private RedemptionType redemptionType;

    public Coupon(String id, List<Item> items, double amount, String category, Date validity, RedemptionType redemptionType) {
        this.id = id;
        this.items = items;
        this.amount = amount;
        this.category = category;
        this.validity = validity;
        this.redemptionType = redemptionType;
    }

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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String categfory) {
        this.category = categfory;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValididty(Date validity) {
        this.validity = validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public RedemptionType getRedemptionType() {
        return redemptionType;
    }

    public void setRedemptionType(RedemptionType redemptionType) {
        this.redemptionType = redemptionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coupon)) return false;
        Coupon coupon = (Coupon) o;
        return Double.compare(coupon.getAmount(), getAmount()) == 0 &&
                Objects.equals(getId(), coupon.getId()) &&
                Objects.equals(getItems(), coupon.getItems()) &&
                Objects.equals(getCategory(), coupon.getCategory()) &&
                Objects.equals(getValidity(), coupon.getValidity()) &&
                getRedemptionType() == coupon.getRedemptionType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getItems(), getAmount(), getCategory(), getValidity(), getRedemptionType());
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id='" + id + '\'' +
                ", items=" + items +
                ", amount=" + amount +
                ", category='" + category + '\'' +
                ", validity=" + validity +
                ", redemptionType=" + redemptionType +
                '}';
    }
}
