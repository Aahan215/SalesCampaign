package org.saleCampaign.controller;

import org.saleCampaign.entity.Product;
import org.saleCampaign.entity.ProductPriceHistory;
import org.saleCampaign.service.ProductPriceHistoryService;
import org.saleCampaign.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final ProductPriceHistoryService priceHistoryService;

    @Autowired
    public ProductController(ProductService productService, ProductPriceHistoryService priceHistoryService) {
        this.productService = productService;
        this.priceHistoryService = priceHistoryService;
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable String productId) {
        return productService.getProductById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @GetMapping("/{productId}/price-history")
    public List<ProductPriceHistory> getProductPriceHistory(@PathVariable String productId) {
        return priceHistoryService.getPriceHistoryForProduct(productId);
    }
}
