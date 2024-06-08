package com.example.eshop.service.dao;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserDao extends UserDetailsService {

    User findByEmail(String email);

}
