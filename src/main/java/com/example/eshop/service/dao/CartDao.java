package com.example.eshop.service.dao;

import com.example.eshop.model.Cart;
import com.example.eshop.model.User;
import org.springframework.security.access.annotation.Secured;

import java.util.List;
import java.util.Optional;

@Secured("USER")
public interface CartDao {

    List<Cart> findAll(String user);

    Optional<Cart> find(Long id, User user);

    Optional<Cart> getOpenCart(String user);

    List<Cart> getAllCarts(String user);

    Cart save(Cart cart);
}
