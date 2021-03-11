package com.halodoc.campaign.api;

import com.halodoc.campaign.model.Campaign;
import com.halodoc.campaign.model.User;
import com.halodoc.campaign.service.CampaignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("campaign")
public class CampaignController {

    private static final Logger LOG = LoggerFactory.getLogger(CampaignController.class);

    @Autowired
    private CampaignService campaignService;

    @RequestMapping(value = "{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Map<User, List<Campaign>> getCampaigns(@PathVariable("userId") String userId) {
        LOG.info("getCampaigns:: " + userId);

        campaignService.getCampaigns(Collections.emptyList());

        return campaignService.getCampaigns(userId);
    }
}
