package com.example.flowershop.web;

import com.example.flowershop.service.UserService;
import com.example.flowershop.web.dto.UserRegistrarionDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrarionDto userRegistrarionDto() {
        return new UserRegistrarionDto();
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrarionDto userRegistrarionDto) {
        userService.save(userRegistrarionDto);
        return "redirect:/registration?success";
    }
    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }
}
