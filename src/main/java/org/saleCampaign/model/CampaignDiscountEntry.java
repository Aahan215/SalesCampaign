package org.saleCampaign.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CampaignDiscountEntry {
    private String productId;
    private String discount;
}
