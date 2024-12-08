package com.sujit.Expense.repository;

import com.sujit.Expense.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    // Additional custom query methods can be added if needed
    List<Expense> findAllByuserId(String userId);
}