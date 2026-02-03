package com.example.investmentportfolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(
        name = "unit_prices",
        uniqueConstraints = @UniqueConstraint(columnNames = "nav_date")
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnitPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "nav_date", nullable = false)
    private LocalDate navDate;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal price;
}
