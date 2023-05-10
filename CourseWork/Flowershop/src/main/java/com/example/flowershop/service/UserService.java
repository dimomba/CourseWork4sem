package com.example.flowershop.service;

import com.example.flowershop.model.User;
import com.example.flowershop.web.dto.UserRegistrarionDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrarionDto userRegistrarionDto);
}
