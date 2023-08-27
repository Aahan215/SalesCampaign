package org.saleCampaign;

import org.saleCampaign.entity.Product;
import org.saleCampaign.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@SpringBootApplication
@EnableSwagger2
public class SaleCampaignApplication {

    private final ProductRepository productRepository;

    @Autowired
    public SaleCampaignApplication(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SaleCampaignApplication.class, args);
    }

    @PostConstruct
    public void initializeData() {
        // Create and save products with actual data
        Product product1 = new Product();
        product1.setId("p1");
        product1.setTitle("Product 1");
        product1.setDescription("Description 1");
        product1.setMrp(BigDecimal.valueOf(300));
        product1.setCurrentPrice(BigDecimal.valueOf(250));
        product1.setDiscount(BigDecimal.valueOf(16.66));
        product1.setInventoryCount(2);
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setId("p2");
        product2.setTitle("Product 2");
        product2.setDescription("Description 2");
        product2.setMrp(BigDecimal.valueOf(500));
        product2.setCurrentPrice(BigDecimal.valueOf(400));
        product2.setDiscount(BigDecimal.valueOf(20.0));
        product2.setInventoryCount(5);
        productRepository.save(product2);

        // Add more products as needed
    }
}
