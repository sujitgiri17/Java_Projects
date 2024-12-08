package com.sujit.Expense.controller;

import com.sujit.Expense.entity.Expense;
import com.sujit.Expense.entity.User;
import com.sujit.Expense.services.ExpenseService;
import com.sujit.Expense.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class ExpenseController {

    private final ExpenseService expenseService;
    private final UserService userService;

    @Autowired
    public ExpenseController(ExpenseService expenseService, UserService userService) {
        this.expenseService = expenseService;
        this.userService = userService;
    }

    @PostMapping("/additem")
    public String addItem(@RequestParam String itemName,
                          @RequestParam Long amount,
                          @RequestParam String category,
                          @RequestParam LocalDate expenseDate,
                          Authentication authentication) {

        String userEmail = authentication.getName(); // Get current user's email
        User user = userService.findByEmail(userEmail); // Fetch user by email

        if (user != null) {
            Expense expense = new Expense();
            expense.setItemName(itemName);
            expense.setAmount(amount);
            expense.setCategory(category);
            expense.setExpenseDate(expenseDate);

            expense.setuserId(user.getEmail());

            // Save the expense using the ExpenseService
            expenseService.saveExpense(expense);
        }

        return "redirect:/home"; // Redirect to home page after adding the expense
    }

}

