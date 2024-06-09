package com.example.eshop.service.dao;

import com.example.eshop.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserDao extends UserDetailsService {

    User findByEmail(String email);

}
