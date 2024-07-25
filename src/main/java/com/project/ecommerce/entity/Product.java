package com.project.ecommerce.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Product extends BaseEntity
{
    private String name;
    private Double price;
    private int stock;
}
