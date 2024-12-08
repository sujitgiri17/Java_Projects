package com.sujit.Expense.controller;

import com.sujit.Expense.entity.User;
import com.sujit.Expense.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @GetMapping("/")
    public String root(Authentication authentication) {
        return authentication != null && authentication.isAuthenticated() ? "redirect:/home" : "index";
    }
    @GetMapping("/login")
    public String login() {
        return "login"; // Return the login HTML page
    }

    @GetMapping("/signup")
    public  String signup() {
        return "signup";

    }

}