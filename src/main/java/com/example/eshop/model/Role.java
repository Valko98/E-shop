package com.example.eshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Role {

    @Id
    @Column(name = "id_role")
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;

    private String name;

    public Role() {

    }
    public Role(String name) {
        this.name = name;
    }
}
