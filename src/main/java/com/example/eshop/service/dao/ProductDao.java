package com.example.eshop.service.dao;

import com.example.eshop.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);

    void deleteById(Long id);
}
