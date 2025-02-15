package com.example.bankapplication.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BankTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String name;
    private String email;

    @Column(name = "account_balance")
    private BigDecimal accountBalance;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private BigDecimal transactionAmount;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    public BankTransaction() {
        this.transactionDate = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public BigDecimal getAccountBalance() { return accountBalance; }
    public void setAccountBalance(BigDecimal accountBalance) { this.accountBalance = accountBalance; }
    public TransactionType getTransactionType() { return transactionType; }
    public void setTransactionType(TransactionType transactionType) { this.transactionType = transactionType; }
    public BigDecimal getTransactionAmount() { return transactionAmount; }
    public void setTransactionAmount(BigDecimal transactionAmount) { this.transactionAmount = transactionAmount; }
    public LocalDateTime getTransactionDate() { return transactionDate; }
    public void setTransactionDate(LocalDateTime transactionDate) { this.transactionDate = transactionDate; }
}
