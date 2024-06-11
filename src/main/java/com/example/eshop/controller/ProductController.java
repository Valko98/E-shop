package com.example.eshop.controller;

import com.example.eshop.model.dto.ProductDto;
import com.example.eshop.service.dao.ProductDao;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductDao productDao;

    @GetMapping
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("products", productDao.findAll());

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create(ProductDto product) {
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", product );

        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("product/delete");
        productDao.deleteById(id);

        return list();
    }
    @PostMapping("save")
    public ModelAndView save(ProductDto product, BindingResult result) {
        if(result.hasErrors()) {
            return create(product);
        }
        product.createProductDto(product.toModel(productDao, result));

        return list();
    }
}
