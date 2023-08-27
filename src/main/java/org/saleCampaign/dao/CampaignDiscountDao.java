package org.saleCampaign.dao;

import org.saleCampaign.pojo.CampaignDiscountPojo;
import org.saleCampaign.pojo.CampaignPojo;
import org.saleCampaign.pojo.ProductPojo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class CampaignDiscountDao extends AbstractDao {
    private static String SELECT_ALL = "select p from CampaignDiscountPojo p";

    private static String SELECT_DISCOUNT = "select p from CampaignDiscountPojo p where p.product.productId=:productId and p.campaign.id=:campaignId";

    // get discount by campaign id and product id
    @PersistenceContext
    private EntityManager em;
    @Transactional
    public void insert(CampaignDiscountPojo pojo) {
        em.persist(pojo);
    }

    public BigDecimal selectDiscount(String productId, Long campaignId) {
        TypedQuery<CampaignDiscountPojo> query = getQuery(SELECT_DISCOUNT, CampaignDiscountPojo.class);
        query.setParameter("productId", productId);
        query.setParameter("campaignId", campaignId);
        return getSingle(query).getDiscount();
    }

}
