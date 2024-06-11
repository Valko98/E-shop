package com.example.eshop.model.dto;

import com.example.eshop.model.Cart;
import com.example.eshop.model.Product;
import com.example.eshop.model.User;
import com.example.eshop.service.dao.CartDao;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class CartDto {
    private Long id;
    private User user;
    private Boolean closed;
    private LocalDateTime dateTime;
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotEmpty(message = "user cannot be empty")
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public Cart toModel(CartDao cartDao, User user, BindingResult result) {
        Cart cart = new Cart();

        if(getId() != null) {
            Optional<Cart> cartOpt = cartDao.find(getId(),user);
            if(cartOpt.isPresent()) {
                cart = cartOpt.get();
            }
        }
        cart.setDateTime(getDateTime());
        cart.setUser(getUser().getFirstName());
        cart.setProducts(getProducts());

        return cart;
    }

    public CartDto createCartDTO(Cart cart, User user) {
        setId(cart.getId());
        setUser(user);
        setClosed(cart.getClosed());
        setDateTime(cart.getDateTime());
        setProducts(cart.getProducts());
        return this;
    }

}
