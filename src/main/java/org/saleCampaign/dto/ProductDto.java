package org.saleCampaign.dto;

import org.saleCampaign.model.ProductData;
import org.saleCampaign.pojo.CampaignPojo;
import org.saleCampaign.pojo.ProductPojo;
import org.saleCampaign.service.ApiException;
import org.saleCampaign.service.CampaignService;
import org.saleCampaign.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.saleCampaign.util.ConversionUtil.convert;

@Component
public class ProductDto {

    @Autowired
    private ProductService productService;
    @Autowired
    private CampaignService campaignService;
    public List<ProductData> getAll() {
        List<ProductPojo> list = productService.getAll();
        List<ProductData> list2 = new ArrayList<>();
        LocalDate currentDate= LocalDate.now();
        Long campaignId= campaignService.getOrderDates(currentDate);
        for (ProductPojo p : list) {
            String productId= p.getProductId();
            BigDecimal discount= campaignService.selectDiscount(productId,campaignId);
            list2.add(convert(p, discount));
        }
        return list2;
    }

    public void add(ProductPojo p) throws ApiException {
        productService.add(p);
    }
}
