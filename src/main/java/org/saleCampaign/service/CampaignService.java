package org.saleCampaign.service;

import org.saleCampaign.entity.Campaign;
import org.saleCampaign.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {

    private final CampaignRepository campaignRepository;

    @Autowired
    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    public Optional<Campaign> getCampaignById(Long campaignId) {
        return campaignRepository.findById(campaignId);
    }

    public List<Campaign> getPastCampaigns() {
        return campaignRepository.findByEndDateBeforeOrderByEndDateDesc(LocalDateTime.now());
    }

    public List<Campaign> getCurrentCampaigns() {
        return campaignRepository.findByStartDateBeforeAndEndDateAfterOrderByStartDateDesc(LocalDateTime.now(), LocalDateTime.now());
    }

    public List<Campaign> getUpcomingCampaigns() {
        return campaignRepository.findByStartDateAfterOrderByStartDateAsc(LocalDateTime.now());
    }

    public Campaign saveCampaign(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    public void deleteCampaign(Long campaignId) {
        campaignRepository.deleteById(campaignId);
    }
}
