package com.example.eshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_cart")
    @SequenceGenerator(name = "product_seq", sequenceName = "product_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    private Long id;

    @Column(nullable = false)
    String user;

    @Column(nullable = false)
    private Boolean closed = false;

    private LocalDateTime dateTime;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cart_has_product", joinColumns = @JoinColumn(name = "id_cart"),
            inverseJoinColumns = @JoinColumn(name = "id_product"))
    private List<Product> products;

    private Double total = 0d;

}
