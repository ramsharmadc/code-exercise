package com.halodoc.campaign.api;

import com.halodoc.campaign.model.Coupon;
import com.halodoc.campaign.model.User;
import com.halodoc.campaign.service.CouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("coupon")
public class CouponController {

    private static final Logger LOG = LoggerFactory.getLogger(CouponController.class);

    @Autowired
    private CouponService couponService;

    @RequestMapping(value = "{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<User, List<Coupon>> getCoupons(@PathVariable("userId") String userId) {
        LOG.info("getCoupons:: " + userId);
        return couponService.getCoupons(userId);
    }
}
