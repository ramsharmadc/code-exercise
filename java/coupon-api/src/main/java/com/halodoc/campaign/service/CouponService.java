package com.halodoc.campaign.service;

import com.halodoc.campaign.model.Coupon;
import com.halodoc.campaign.model.User;
import com.halodoc.campaign.persistence.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CouponService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RuleService ruleService;

    public Map<User, List<Coupon>> getCoupons(String userId) {

        Map<User, List<Coupon>> result = new HashMap<>();
        return result;
    }

    public Map<User, List<Coupon>> getCoupons(List<User> userList) {
        return Collections.emptyMap();
    }

    public Map<User, List<Coupon>> getCoupons(User user) {
        return Collections.emptyMap();
    }
}
