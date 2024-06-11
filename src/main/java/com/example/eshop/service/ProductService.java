package com.example.eshop.service;

import com.example.eshop.model.Product;
import com.example.eshop.repository.ProductRepository;
import com.example.eshop.service.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductDao {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }
}
