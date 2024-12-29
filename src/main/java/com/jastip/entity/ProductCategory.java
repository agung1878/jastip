package com.jastip.entity;


import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class ProductCategory extends BaseEntity{

    private String name;
    private String description;

}
