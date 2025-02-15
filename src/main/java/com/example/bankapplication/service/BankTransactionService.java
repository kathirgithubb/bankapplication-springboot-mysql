package com.example.bankapplication.service;

import com.example.bankapplication.entity.BankTransaction;
import com.example.bankapplication.entity.TransactionType;
import com.example.bankapplication.repository.BankTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BankTransactionService {

    @Autowired
    private BankTransactionRepository bankTransactionRepository;

    public BankTransaction createTransaction(Long userId, String name, String email, BigDecimal amount, TransactionType transactionType) {
        BankTransaction bankTransaction = new BankTransaction();
        bankTransaction.setUserId(userId);
        bankTransaction.setName(name);
        bankTransaction.setEmail(email);
        bankTransaction.setTransactionAmount(amount);
        bankTransaction.setTransactionType(transactionType);

        if (transactionType == TransactionType.WITHDRAWAL) {
            bankTransaction.setAccountBalance(BigDecimal.ZERO.subtract(amount)); // Withdraw
        } else {
            bankTransaction.setAccountBalance(BigDecimal.ZERO.add(amount)); // Deposit
        }

        return bankTransactionRepository.save(bankTransaction);
    }

    public BigDecimal getAccountBalance(Long userId) {
        BankTransaction latestTransaction = bankTransactionRepository
                .findAll()
                .stream()
                .filter(t -> t.getUserId().equals(userId))
                .reduce((first, second) -> second) // Get the most recent transaction
                .orElseThrow(() -> new RuntimeException("Account not found"));

        return latestTransaction.getAccountBalance();
    }
}
