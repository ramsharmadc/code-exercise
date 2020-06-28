package com.halodoc.campaign.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Campaign {

    private String id;
    private Map<User, List<Coupon>> userCouponMap;

    public Campaign(String id, Map<User, List<Coupon>> userCouponMap) {
        this.id = id;
        this.userCouponMap = userCouponMap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<User, List<Coupon>> getUserCouponMap() {
        return userCouponMap;
    }

    public void setUserCouponMap(Map<User, List<Coupon>> userCouponMap) {
        this.userCouponMap = userCouponMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Campaign)) return false;
        Campaign campaign = (Campaign) o;
        return Objects.equals(getId(), campaign.getId()) &&
                Objects.equals(getUserCouponMap(), campaign.getUserCouponMap());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserCouponMap());
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "id='" + id + '\'' +
                ", userCouponMap=" + userCouponMap +
                '}';
    }
}
