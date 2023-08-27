package org.saleCampaign.dto;

import org.saleCampaign.model.CampaignData;
import org.saleCampaign.model.CampaignDiscountEntry;
import org.saleCampaign.model.ProductData;
import org.saleCampaign.model.ProductForm;
import org.saleCampaign.pojo.CampaignDiscountPojo;
import org.saleCampaign.pojo.CampaignPojo;
import org.saleCampaign.pojo.ProductPojo;
import org.saleCampaign.pojo.ProductPriceHistoryPojo;
import org.saleCampaign.service.ApiException;
import org.saleCampaign.service.CampaignService;
import org.saleCampaign.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.saleCampaign.util.ConversionUtil.convert;

@Component
public class CampaignDto {

    @Autowired
    private CampaignService campaignService;
    @Autowired
    private ProductService productService;

    public void createCampaign(CampaignData campaignData) throws ApiException {
        CampaignPojo pojo= new CampaignPojo();
        pojo.setTitle(campaignData.getTitle());
        pojo.setStartDate(campaignData.getStartDate());
        pojo.setEndDate(campaignData.getEndDate());

        ProductPriceHistoryPojo historyPojo= new ProductPriceHistoryPojo();
        historyPojo.setStartDate(campaignData.getStartDate());
        historyPojo.setEndDate(campaignData.getEndDate());

        List<CampaignDiscountPojo> list= new ArrayList<>();
        List<CampaignDiscountEntry> campaignDiscounts = campaignData.getCampaignDiscount();
        for (CampaignDiscountEntry discountEntry : campaignDiscounts) {
            String productId = discountEntry.getProductId();
            String discountValue = discountEntry.getDiscount();
            ProductPojo product = productService.get(productId);
            CampaignDiscountPojo cp= new CampaignDiscountPojo();
            if (product != null) {
                cp.setDiscount(new BigDecimal(discountValue));
                cp.setProduct(product);
                cp.setCampaign(pojo);
                campaignService.addDiscount(cp);
                list.add(cp);
                BigDecimal originalPrice = product.getCurrentPrice();
                BigDecimal discountPercentage = new BigDecimal(discountValue).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_UP);
                BigDecimal discountedPrice = originalPrice.subtract(originalPrice.multiply(discountPercentage));
                historyPojo.setPrice(discountedPrice);
                historyPojo.setProduct(product);
                productService.add(historyPojo);
            }
        }

        pojo.setCampaignDiscounts(list);
        campaignService.add(pojo);

    }

}
