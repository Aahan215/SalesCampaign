package org.saleCampaign.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class CampaignDiscountPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal discount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductPojo product;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private CampaignPojo campaign;
}
