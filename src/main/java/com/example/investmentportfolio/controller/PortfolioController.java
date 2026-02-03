package com.example.investmentportfolio.controller;

import com.example.investmentportfolio.dto.PortfolioSummaryResponse;
import com.example.investmentportfolio.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping
    public PortfolioSummaryResponse getPortfolioSummary() {
        return portfolioService.getPortfolioSummary();
    }
}
