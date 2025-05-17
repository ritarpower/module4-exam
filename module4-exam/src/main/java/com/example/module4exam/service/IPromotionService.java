package com.example.module4exam.service;

import com.example.module4exam.model.Promotion;

import java.time.LocalDate;
import java.util.List;

public interface IPromotionService {
    List<Promotion> getPromotions();
    void addPromotion(Promotion promotion);
    void deletePromotionById(int id);
    List<Promotion> findByAmountAndStartDateAndEndDate(Double amount, LocalDate startDate, LocalDate endDate);
}
