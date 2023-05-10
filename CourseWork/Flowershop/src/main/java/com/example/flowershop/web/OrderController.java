package com.example.flowershop.web;

import com.example.flowershop.model.Order;
import com.example.flowershop.model.User;
import com.example.flowershop.repository.UserRepository;
import com.example.flowershop.service.OrderService;
import com.example.flowershop.web.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    private Authentication authentication;

    @Autowired
    OrderService orderService;

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public String addOrder(@ModelAttribute("order") OrderDto orderDto) {

        authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User user = userRepository.findByEmail(email);

        Order order = new Order();
        order.setUser(user);
        order.setFlower(orderDto.getFlower());
        order.setCount(orderDto.getCount());
        order.setPriceforone(orderDto.getPriceforone());
        order.setCost(orderDto.getCost());


        orderService.save(order);
        return "redirect:/order?success";
    }

    @GetMapping
    public String order(Model m) {
        m.addAttribute("orders", new OrderDto());
        return "order";
    }
}
