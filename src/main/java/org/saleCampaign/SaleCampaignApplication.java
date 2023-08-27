package org.saleCampaign;

import org.saleCampaign.pojo.ProductPojo;
import org.saleCampaign.service.ApiException;
import org.saleCampaign.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@SpringBootApplication
@EnableSwagger2
public class SaleCampaignApplication {


    @Autowired
    private ProductService productService;

    public static void main(String[] args){
        SpringApplication.run(SaleCampaignApplication.class,args);
    }
    @PostConstruct
    public void initializeData() throws ApiException {
        // Create and save products with actual data
        ProductPojo product1 = new ProductPojo();
        product1.setProductId("jeiu8f03");
        product1.setTitle("Product 1");
        product1.setDescription("Description 1");
        product1.setMrp(BigDecimal.valueOf(300));
        product1.setCurrentPrice(BigDecimal.valueOf(250));
        product1.setInventoryCount(2);
        productService.add(product1);

        ProductPojo product2 = new ProductPojo();
        product2.setProductId("jeiu8f20");
        product2.setTitle("Product 2");
        product2.setDescription("Description 2");
        product2.setMrp(BigDecimal.valueOf(500));
        product2.setCurrentPrice(BigDecimal.valueOf(400));
        product2.setInventoryCount(5);
        productService.add(product2);

        // Add more products as needed
    }
}
