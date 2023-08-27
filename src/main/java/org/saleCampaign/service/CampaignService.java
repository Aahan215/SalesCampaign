package org.saleCampaign.service;

import org.saleCampaign.dao.CampaignDao;
import org.saleCampaign.dao.CampaignDiscountDao;
import org.saleCampaign.dao.ProductDao;
import org.saleCampaign.dto.CampaignDto;
import org.saleCampaign.pojo.CampaignDiscountPojo;
import org.saleCampaign.pojo.CampaignPojo;
import org.saleCampaign.pojo.ProductPojo;
import org.saleCampaign.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {
    @Autowired
    private CampaignDao dao;
    @Autowired
    private CampaignDiscountDao campaignDiscountDao;

    @Transactional(rollbackOn = ApiException.class)
    public void add(CampaignPojo pojo) throws ApiException {
        dao.insert(pojo);
    }

    @Transactional(rollbackOn = ApiException.class)
    public void addDiscount(CampaignDiscountPojo pojo) throws ApiException {
        campaignDiscountDao.insert(pojo);
    }

    @Transactional
    public Long getOrderDates(LocalDate date) {
        return dao.selectIdByDate(date).getId();
    }
    @Transactional
    public BigDecimal selectDiscount(String productId, Long campaignId){
        return campaignDiscountDao.selectDiscount(productId,campaignId);
    }
}
