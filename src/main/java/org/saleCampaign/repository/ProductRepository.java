package org.saleCampaign.repository;

import org.saleCampaign.pojo.ProductPojo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductPojo, String> {
}
