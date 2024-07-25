package com.project.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Orderr extends BaseEntity{
    //Order diye tanımladığımda proje kalkmıyor. O yüzden orderr

    @ManyToOne
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
    private double totalPrice;
    private String orderCode;
}
