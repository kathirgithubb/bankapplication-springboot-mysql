package com.example.bankapplication.repository;

import com.example.bankapplication.entity.BankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankTransactionRepository extends JpaRepository<BankTransaction, Long> {
}
