package org.saleCampaign.repository;

import org.saleCampaign.entity.ProductPriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductPriceHistoryRepository extends JpaRepository<ProductPriceHistory, Long> {
    List<ProductPriceHistory> findByProduct_IdOrderByDateTimeDesc(String productId);
}