package org.saleCampaign.util;

import org.saleCampaign.model.CampaignData;
import org.saleCampaign.model.ProductData;
import org.saleCampaign.pojo.CampaignPojo;
import org.saleCampaign.pojo.ProductPojo;

import java.math.BigDecimal;

public class ConversionUtil {
    public static ProductData convert(ProductPojo pojo, BigDecimal discount) {
        BigDecimal mrp= pojo.getMrp();
        BigDecimal x= BigDecimal.valueOf(100);
        BigDecimal currentPrice = mrp.multiply(x.subtract(discount).divide(x));
        ProductData data = new ProductData();
        data.setId(pojo.getProductId());
        data.setMrp(mrp);
        data.setCurrentPrice(currentPrice);
        data.setDiscount(discount);
        data.setInventory(pojo.getInventoryCount());
        return data;
    }

    public static CampaignPojo convert(CampaignData data) {
        CampaignPojo pojo= new CampaignPojo();
        return pojo;
    }
}
