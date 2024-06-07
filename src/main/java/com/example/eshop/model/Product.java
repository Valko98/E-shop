package com.example.eshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "product")
public class Product {

    @Id
    @Column(name = "id_product")
    @SequenceGenerator(name = "product_seq", sequenceName = "product_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @Getter
    @Setter
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private double price;

    public Product() {

    }
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

}
