package com.halodoc.campaign.service;

import com.halodoc.campaign.model.Campaign;
import com.halodoc.campaign.model.User;
import com.halodoc.campaign.persistence.UserDAO;
import com.halodoc.campaign.persistence.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CampaignService {

    @Autowired
    private RuleService ruleService;

    @Autowired
    private UsersRepository usersRepository;

    public Map<User, List<Campaign>> getCampaigns(String userId) {
        Optional<UserDAO> optionalUsers = usersRepository.findById(userId);
        optionalUsers.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        List<Campaign> applicableCampaigns =
                ruleService.apply(optionalUsers.map(User::new).get());
        Map<User, List<Campaign>> result = new HashMap<>();
        result.put(optionalUsers.map(User::new).get(), applicableCampaigns);
        return result;
    }

    public Map<User, List<Campaign>> getCampaigns(User user) {
        return Collections.emptyMap();
    }

    public Map<User, List<Campaign>> getCampaigns(List<User> userList) {
        return Collections.emptyMap();
    }
}
