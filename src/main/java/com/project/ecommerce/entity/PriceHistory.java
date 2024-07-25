package com.project.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class PriceHistory extends BaseEntity {

    @ManyToOne
    private Product product;
    private double price;

    @OneToOne
    private Orderr orderr;

}
