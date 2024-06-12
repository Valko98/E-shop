package com.example.eshop.service;

import com.example.eshop.model.Cart;
import com.example.eshop.model.User;
import com.example.eshop.repository.CartRepository;
import com.example.eshop.service.dao.CartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService implements CartDao {

    @Autowired
    private CartRepository repository;

    @Override
    public List<Cart> findAll(String user) {
        if (user == null) {
            return null;
        }

        return repository.findAllByUser(user);
    }

    @Override
    public Optional<Cart> find(Long id, User user) {
        if (user == null) {
            return Optional.empty();
        }

        return repository.findByIdAndUser(id, user.getName());
    }

    @Override
    public Optional<Cart> getOpenCart(String user) {
        return repository.findByUserAndClosed(user, false);
    }

    @Override
    public List<Cart> getAllCarts(String user) {
        return repository.findAllByUser(user);
    }

    @Override
    public Cart save(Cart cart) {
        return repository.save(cart);
    }

}