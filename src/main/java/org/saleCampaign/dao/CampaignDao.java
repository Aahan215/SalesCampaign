package org.saleCampaign.dao;

import org.saleCampaign.pojo.CampaignPojo;
import org.saleCampaign.pojo.ProductPojo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class CampaignDao extends AbstractDao {
    private static String SELECT_ALL = "select p from CampaignPojo p";
    private static String SELECT_ID_BY_DATE = "select p from CampaignPojo p WHERE :date BETWEEN startDate AND endDate";

    @PersistenceContext
    private EntityManager em;
    @Transactional
    public void insert(CampaignPojo pojo) {
        em.persist(pojo);
    }

    public List<ProductPojo> selectAll() {
        TypedQuery<ProductPojo> query = getQuery(SELECT_ALL, ProductPojo.class);
        return query.getResultList();
    }

    public CampaignPojo selectIdByDate(LocalDate date) {
        TypedQuery<CampaignPojo> query = getQuery(SELECT_ID_BY_DATE, CampaignPojo.class);
        query.setParameter("date", date);
        return (CampaignPojo) query.getResultList();
    }

}
