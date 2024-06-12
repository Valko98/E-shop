package com.example.eshop.controller;

import com.example.eshop.model.Cart;
import com.example.eshop.model.Product;
import com.example.eshop.security.model.AuthenticationFacade;
import com.example.eshop.service.ProductService;
import com.example.eshop.service.dao.CartDao;
import com.example.eshop.service.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller("/")
public class HomeController {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CartDao cartDao;

    @Autowired
    private AuthenticationFacade authentication;
    @Autowired
    private ProductService productService;

    @GetMapping
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("/home/home");
        modelAndView.addObject("products", productDao.findAll());

        Integer cartQuantity = 0;

        Authentication auth = authentication.getAuthentication();
        if(!(auth instanceof AnonymousAuthenticationToken)) {
            modelAndView.addObject("user", auth.getName());

            Optional<Cart> oCart = cartDao.getOpenCart(auth.getName());
            if(oCart.isPresent()) {
                cartQuantity = oCart.get().getProducts().size();
            }
        }
        modelAndView.addObject("cartQuantity", cartQuantity);

        return modelAndView;
    }
    @GetMapping("{id}")
    public ModelAndView show(@PathVariable("id") Long id) {
        Optional<Product> product = productService.findById(id);

        if(product.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/home/detail");
            modelAndView.addObject("product", product.get());

            Authentication auth = authentication.getAuthentication();
            if(!(auth instanceof AnonymousAuthenticationToken)) {
                modelAndView.addObject("user", auth.getName());
            }

            return modelAndView;
        } else {
            return list();
        }
    }
}
