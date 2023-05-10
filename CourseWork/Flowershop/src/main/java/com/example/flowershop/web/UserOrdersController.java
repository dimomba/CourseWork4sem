package com.example.flowershop.web;

import com.example.flowershop.model.Order;
import com.example.flowershop.repository.OrderRepository;
import com.example.flowershop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserOrdersController {

    private Authentication authentication;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/userOrders")
    public String userOrders(Model model) {

        authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        List<Order> list = orderRepository.findAllByUser(userRepository.findByEmail(email));

        model.addAttribute("orders", list);

        return "userOrders";
    }

}
