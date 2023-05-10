package com.example.flowershop.web;

import com.example.flowershop.model.Order;
import com.example.flowershop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    OrderRepository orderRepository;

    private Authentication authentication;

    @GetMapping()
    public String userOrders(Model model) {

        List<Order> list = orderRepository.findAll();

        model.addAttribute("orders", list);

        return "admin";
    }

    @GetMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        orderRepository.deleteById(id);
        authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        if (email.equals("admin")) {
            return "redirect:/admin";
        }
        else {
            return "redirect:/userOrders";
        }
    }
}
