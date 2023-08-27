package org.saleCampaign.service;

import org.saleCampaign.dao.ProductDao;
import org.saleCampaign.pojo.ProductPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao dao;

    @Transactional(rollbackOn = ApiException.class)
    public void add(ProductPojo pojo) throws ApiException {
        dao.insert(pojo);
    }

    @Transactional
    public ProductPojo get(String id) throws ApiException{
        return dao.select(id);
    }
    @Transactional
    public List<ProductPojo> getAll() {
        return dao.selectAll();
    }
}
