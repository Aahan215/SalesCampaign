package org.saleCampaign.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;


@Entity
@Getter
@Setter
public class Product {
    @Id
    private Integer productId;
    private String title;
    private String description;
    private BigDecimal mrp;
    private BigDecimal currentPrice;
    private Integer inventoryCount;

}