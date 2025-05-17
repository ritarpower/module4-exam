package com.example.module4exam.service;

import com.example.module4exam.model.Promotion;
import com.example.module4exam.repository.IPromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PromotionService implements IPromotionService {

    @Autowired
    private IPromotionRepository promotionRepository;

    @Override
    public List<Promotion> getPromotions() {
        return promotionRepository.findAll();
    }

    @Override
    public void addPromotion(Promotion promotion) {
        promotionRepository.save(promotion);
    }

    @Override
    public void deletePromotionById(int id) {
        promotionRepository.deleteById(id);
    }

    @Override
    public List<Promotion> findByAmountAndStartDateAndEndDate(Double amount, LocalDate startDate, LocalDate endDate) {
        return promotionRepository.findByCriteria(amount, startDate, endDate);
    }
}
