package com.example.investmentportfolio.service;

import com.example.investmentportfolio.dto.PortfolioSummaryResponse;
import com.example.investmentportfolio.entity.InvestmentTransaction;
import com.example.investmentportfolio.entity.UnitPrice;
import com.example.investmentportfolio.repository.InvestmentTransactionRepository;
import com.example.investmentportfolio.repository.UnitPriceRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PortfolioService {

    private final InvestmentTransactionRepository transactionRepository;
    private final UnitPriceRepository unitPriceRepository;

    public PortfolioService(InvestmentTransactionRepository transactionRepository,
                            UnitPriceRepository unitPriceRepository) {
        this.transactionRepository = transactionRepository;
        this.unitPriceRepository = unitPriceRepository;
    }

    public PortfolioSummaryResponse getPortfolioSummary() {

        List<InvestmentTransaction> transactions = transactionRepository.findAll();

        BigDecimal totalUnits = calculateTotalUnits(transactions);
        UnitPrice latestPrice = getLatestUnitPrice();

        BigDecimal currentNav = latestPrice.getPrice();
        BigDecimal currentBalance = totalUnits.multiply(currentNav);

        BigDecimal totalInvested = calculateTotalInvested(transactions);

        BigDecimal totalReturn = currentBalance.subtract(totalInvested);

        return buildResponse(
                totalUnits,
                currentNav,
                currentBalance,
                totalInvested,
                totalReturn
        );
    }

    private BigDecimal calculateTotalUnits(List<InvestmentTransaction> transactions) {
        return transactions.stream()
                .map(InvestmentTransaction::getUnits)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private UnitPrice getLatestUnitPrice() {
        return unitPriceRepository
                .findTopByOrderByNavDateDesc()
                .orElseThrow(() ->
                        new IllegalStateException("Latest unit price not found"));
    }

    private BigDecimal calculateTotalInvested(List<InvestmentTransaction> transactions) {
        return transactions.stream()
                .map(this::calculateInvestedAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateInvestedAmount(InvestmentTransaction transaction) {

        LocalDate hPlusOneDate = transaction.getTransactionDate().plusDays(1);

        UnitPrice priceAtHPlusOne = unitPriceRepository
                .findFirstByNavDateGreaterThanEqualOrderByNavDateAsc(hPlusOneDate)
                .orElseThrow(() ->
                        new IllegalStateException(
                                "Unit price not found for H+1 date: " + hPlusOneDate
                        ));

        return transaction.getUnits()
                .multiply(priceAtHPlusOne.getPrice());
    }

    private PortfolioSummaryResponse buildResponse(
            BigDecimal totalUnits,
            BigDecimal currentNav,
            BigDecimal currentBalance,
            BigDecimal totalInvested,
            BigDecimal totalReturn) {

        return PortfolioSummaryResponse.builder()
                .totalUnits(totalUnits)
                .currentNav(currentNav)
                .currentBalance(currentBalance)
                .totalInvested(totalInvested)
                .totalReturn(totalReturn)
                .build();
    }
}

