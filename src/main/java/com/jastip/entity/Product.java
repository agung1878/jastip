package com.jastip.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Product extends BaseEntity {

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_product_category", nullable = false)
    private ProductCategory category;

    private BigDecimal price;

}

