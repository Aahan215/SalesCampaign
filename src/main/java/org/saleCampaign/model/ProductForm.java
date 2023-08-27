package org.saleCampaign.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductForm {
	private BigDecimal mrp;
	private BigDecimal currentPrice;
	private BigDecimal discount;
	private Integer inventory;
}
