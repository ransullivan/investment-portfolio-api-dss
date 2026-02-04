package com.example.investmentportfolio.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@Builder
@JsonPropertyOrder({"totalUnits", "currentNav", "currentBalance", "totalInvested", "totalReturn"})
public class PortfolioSummaryResponse {

    private BigDecimal totalUnits;
    private BigDecimal currentNav;
    private BigDecimal currentBalance;
    private BigDecimal totalInvested;
    private BigDecimal totalReturn;

        // Custom builder untuk format BigDecimal
        public static class PortfolioSummaryResponseBuilder {
            private BigDecimal format(BigDecimal value) {
                if (value == null) return null;
                int scale = value.stripTrailingZeros().scale();
                int decimalPlaces = scale > 2 ? 4 : 2;
                return value.setScale(decimalPlaces, RoundingMode.HALF_UP);
            }

            public PortfolioSummaryResponseBuilder totalUnits(BigDecimal totalUnits) {
                this.totalUnits = format(totalUnits);
                return this;
            }

            public PortfolioSummaryResponseBuilder currentNav(BigDecimal currentNav) {
                this.currentNav = format(currentNav);
                return this;
            }

            public PortfolioSummaryResponseBuilder currentBalance(BigDecimal currentBalance) {
                this.currentBalance = format(currentBalance);
                return this;
            }

            public PortfolioSummaryResponseBuilder totalInvested(BigDecimal totalInvested) {
                this.totalInvested = format(totalInvested);
                return this;
            }

            public PortfolioSummaryResponseBuilder totalReturn(BigDecimal totalReturn) {
                this.totalReturn = format(totalReturn);
                return this;
            }
        }
    }

