package com.example.bankapplication.controller;

import com.example.bankapplication.entity.BankTransaction;
import com.example.bankapplication.entity.TransactionType;
import com.example.bankapplication.service.BankTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/bank")
public class BankTransactionController {

    @Autowired
    private BankTransactionService bankTransactionService;

    @PostMapping("/createTransaction")
    public BankTransaction createTransaction(
            @RequestParam Long userId,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam BigDecimal amount,
            @RequestParam TransactionType transactionType) {
        return bankTransactionService.createTransaction(userId, name, email, amount, transactionType);
    }

    @GetMapping("/getBalance")
    public BigDecimal getAccountBalance(@RequestParam Long userId) {
        return bankTransactionService.getAccountBalance(userId);
    }
}
