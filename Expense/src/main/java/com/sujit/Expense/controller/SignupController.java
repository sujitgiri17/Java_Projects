package com.sujit.Expense.controller;


import com.sujit.Expense.entity.User;
import com.sujit.Expense.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignupController {
    private final PasswordEncoder passwordEncoder;

    public SignupController( PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Autowired
    private UserRepository userRepository; // Assuming you have a UserRepository



    @PostMapping("/submitsignup")
    public String addNewUser(@RequestParam String name,
                             @RequestParam String email,
                             @RequestParam String password,
                             @RequestParam String confirm_password,
                             Model model) {



        // Here you can perform additional validation/logic as needed

        // Example: Saving user data to a repository (replace this with your actual repository logic)
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        userRepository.save(user);

        return "redirect:/home"; // Redirect to the home page after successful signup
    }

}
