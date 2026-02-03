package com.example.investmentportfolio.repository;

import com.example.investmentportfolio.entity.InvestmentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InvestmentTransactionRepository
        extends JpaRepository<InvestmentTransaction, UUID> {
}
