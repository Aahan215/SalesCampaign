package org.saleCampaign.repository;

import org.saleCampaign.pojo.ProductPriceHistoryPojo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductPriceHistoryRepository extends JpaRepository<ProductPriceHistoryPojo, Long> {
    List<ProductPriceHistoryPojo> findByProduct_IdOrderByDateTimeDesc(String productId);
}