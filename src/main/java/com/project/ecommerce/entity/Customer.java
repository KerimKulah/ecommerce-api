package com.project.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Customer extends BaseEntity {

    private String name;

    @JsonManagedReference
    @OneToOne(mappedBy = "customer")
    private Cart cart;

    @OneToMany
    private List<Orderr> orders;

}
