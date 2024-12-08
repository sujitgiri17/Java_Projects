package com.sujit.Expense.controller;

import com.sujit.Expense.entity.Expense;
import com.sujit.Expense.entity.User;
import com.sujit.Expense.repository.UserRepository;
import com.sujit.Expense.services.ExpenseService;
import com.sujit.Expense.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    UserRepository userRepository;
    private final UserService userService;
    private final ExpenseService expenseService;


    @Autowired // Ensure proper autowiring
    public HomeController(UserService userService, ExpenseService expenseService) {
        this.userService = userService;
        this.expenseService = expenseService;
    }
    @GetMapping("/home")
    public String home(Model model, Authentication authentication){
        System.out.println("In home");
        String email = authentication.getName();
        User user = userService.findByEmail(email);
        model.addAttribute("email", user.getName());

        List<Expense> expenses = expenseService.getAllExpensesByUserId(email); // Fetch expenses from the service
        model.addAttribute("expenses", expenses); // Pass expenses to the view
        return "home";

    }

}
