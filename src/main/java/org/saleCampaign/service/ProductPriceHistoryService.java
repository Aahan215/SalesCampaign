package org.saleCampaign.service;

import org.saleCampaign.entity.ProductPriceHistory;
import org.saleCampaign.repository.ProductPriceHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductPriceHistoryService {

    private final ProductPriceHistoryRepository priceHistoryRepository;

    @Autowired
    public ProductPriceHistoryService(ProductPriceHistoryRepository priceHistoryRepository) {
        this.priceHistoryRepository = priceHistoryRepository;
    }

    public List<ProductPriceHistory> getPriceHistoryForProduct(String productId) {
        return priceHistoryRepository.findByProduct_IdOrderByDateTimeDesc(productId);
    }

    public ProductPriceHistory savePriceHistory(ProductPriceHistory priceHistory) {
        return priceHistoryRepository.save(priceHistory);
    }
}
