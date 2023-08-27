package org.saleCampaign.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CampaignData {

	private LocalDate startDate;
	private LocalDate endDate;
	private String title;
	private List<CampaignDiscountEntry> campaignDiscount;
}


