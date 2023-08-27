package org.saleCampaign.dao;

import org.saleCampaign.pojo.ProductPojo;
import org.saleCampaign.pojo.ProductPriceHistoryPojo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductDao extends AbstractDao {
    private static String SELECT_ALL = "select p from ProductPojo p";
    private static String SELECT_ID = "select p from ProductPojo p where id=:id";

    @PersistenceContext
    private EntityManager em;
    @Transactional
    public void insert(ProductPojo p) {
        em.persist(p);
    }

    @Transactional
    public void insert(ProductPriceHistoryPojo p) {
        em.persist(p);
    }

    public List<ProductPojo> selectAll() {
        TypedQuery<ProductPojo> query = getQuery(SELECT_ALL, ProductPojo.class);
        return query.getResultList();
    }

    public ProductPojo select(String id) {
        TypedQuery<ProductPojo> query = getQuery(SELECT_ID, ProductPojo.class);
        query.setParameter("id", id);
        return getSingle(query);
    }

}
