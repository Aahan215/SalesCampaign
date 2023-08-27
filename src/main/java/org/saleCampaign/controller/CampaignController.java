package org.saleCampaign.controller;

import org.saleCampaign.entity.Campaign;
import org.saleCampaign.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {

    private final CampaignService campaignService;

    @Autowired
    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping("/past")
    public List<Campaign> getPastCampaigns() {
        return campaignService.getPastCampaigns();
    }

    @GetMapping("/current")
    public List<Campaign> getCurrentCampaigns() {
        return campaignService.getCurrentCampaigns();
    }

    @GetMapping("/upcoming")
    public List<Campaign> getUpcomingCampaigns() {
        return campaignService.getUpcomingCampaigns();
    }
}
