package com.example.investmentportfolio.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PortfolioSummaryResponse {

    private BigDecimal totalUnits;
    private BigDecimal currentNav;
    private BigDecimal currentBalance;
    private BigDecimal totalInvested;
    private BigDecimal totalReturn;
}
