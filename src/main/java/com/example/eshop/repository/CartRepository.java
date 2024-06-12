package com.example.eshop.repository;

import com.example.eshop.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findAllByUser(String user);

    Optional<Cart> findByIdAndUser(Long id, String user);

    Optional<Cart> findByUserAndClosed(String user, Boolean closed);
}
