package com.sujit.Expense.services;

import com.sujit.Expense.entity.Expense;
import com.sujit.Expense.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void saveExpense(Expense expense) {
        expenseRepository.save(expense);
    }


    public List<Expense> getAllExpensesByUserId(String userId) {
        return expenseRepository.findAllByuserId(userId);
    }
    // Other methods...
}
