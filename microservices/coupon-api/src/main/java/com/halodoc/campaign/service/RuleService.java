package com.halodoc.campaign.service;

import com.halodoc.campaign.model.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RuleService {

    public List<Campaign> apply(User user) {

        Rule locationRule = new Rule();
        locationRule.setLocations(Arrays.asList(user.getLocation()));
        Rule itemBasedRule = new Rule();
        itemBasedRule.setItems(Arrays.asList(new Item("itm-1", "cheese")));

        return getCampaigns(new Rule[]{locationRule, itemBasedRule}, user);
    }

    public List<Campaign> getCampaigns(Rule[] rules, User user) {

        Map<User, List<Coupon>> userCouponMap = new HashMap<>();

        Campaign campaign1 = new Campaign("campaign-1", userCouponMap);
        List<Coupon> coupons = getCoupons(rules);
        campaign1.getUserCouponMap().put(user, coupons);

        Campaign campaign2 = new Campaign("campaign-1", userCouponMap);
        List<Coupon> coupons2 = getCoupons(rules);
        campaign1.getUserCouponMap().put(user, coupons2);

        return Arrays.asList(campaign1, campaign2);
    }

    public List<Coupon> getCoupons(Rule[] rules) {
        List<Coupon> couponsList = new ArrayList<>();
        Arrays.stream(rules).forEach(x -> couponsList.addAll(getCoupons(x)));
        return couponsList;
    }

    public List<Coupon> getCoupons(Rule rule) {
        Item i1 = new Item("itm-1", "cheese");
        RedemptionType redemptionType = RedemptionType.CASHBACK;
        Date validity = Calendar.getInstance().getTime();
        String category = "First100Users";
        double amount = 43.23;
        Coupon cp1 = new Coupon("cpn-1", Arrays.asList(i1),
                amount, category, validity, redemptionType);

        Item i2 = new Item("itm-1", "cheese");
        RedemptionType redemptionType2 = RedemptionType.CASHBACK;
        Date validity2 = Calendar.getInstance().getTime();
        String category2 = "First100Users";
        double amount2 = 43.23;
        Coupon cp2 = new Coupon("cpn-2", Arrays.asList(i2),
                amount2, category2, validity2, redemptionType2);

        return Arrays.asList(cp1, cp2);
    }
}
