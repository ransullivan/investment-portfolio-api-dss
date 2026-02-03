package com.example.investmentportfolio.repository;
import com.example.investmentportfolio.entity.UnitPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UnitPriceRepository
        extends JpaRepository<UnitPrice, UUID> {

    Optional<UnitPrice> findTopByOrderByNavDateDesc();

    Optional<UnitPrice> findFirstByNavDateGreaterThanEqualOrderByNavDateAsc(
            LocalDate navDate
    );
}
