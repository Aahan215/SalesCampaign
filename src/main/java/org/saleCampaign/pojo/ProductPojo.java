package org.saleCampaign.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;


@Entity
@Getter
@Setter
public class ProductPojo {
    @Id
    private String productId;
    private String title;
    private String description;
    private BigDecimal mrp;
    private BigDecimal currentPrice;
    private Integer inventoryCount;
}