package com.example.module4exam.repository;

import com.example.module4exam.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IPromotionRepository extends JpaRepository<Promotion, Integer> {
    @Query("SELECT p FROM Promotion p WHERE " +
            "(:amount IS NULL OR p.amount = :amount) AND " +
            "(:startDate IS NULL OR p.startDate >= :startDate) AND " +
            "(:endDate IS NULL OR p.endDate <= :endDate)")
    List<Promotion> findByCriteria(@Param("amount") Double amount, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
