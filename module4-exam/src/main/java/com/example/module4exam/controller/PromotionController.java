package com.example.module4exam.controller;

import com.example.module4exam.model.Promotion;
import com.example.module4exam.model.PromotionDTO;
import com.example.module4exam.service.IPromotionService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/")
public class PromotionController {
    @Autowired
    private IPromotionService promotionService;

    @GetMapping("")
    public String showAllPromotion(Model model) {
        model.addAttribute("promotions", promotionService.getPromotions());
        return "promotion_page";
    }

    @GetMapping("show-add-promotion")
    public String addPromotionPage(Model model) {
        model.addAttribute("promotionDTO", new PromotionDTO());
        return "add_form";
    }

    @GetMapping("find-promotion")
    public String findPromotion(@RequestParam(name = "amount", required = false) Double amount,
                                @RequestParam(name = "startDate", required = false) LocalDate startDate,
                                @RequestParam(name = "endDate", required = false) LocalDate endDate,
                                Model model) {
        List<Promotion> promotions = promotionService.findByAmountAndStartDateAndEndDate(amount, startDate, endDate);
        model.addAttribute("promotions", promotions);
        return "promotion_page";
    }

    @PostMapping("add-promotion")
    public String addPromotion(@Valid @ModelAttribute("promotionDTO") PromotionDTO promotionDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (promotionDTO.getEndDate().isBefore(promotionDTO.getStartDate()) || promotionDTO.getEndDate().isEqual(promotionDTO.getStartDate())) {
            bindingResult.rejectValue("endDate", "error.promotionDTO", "Ngày kết thúc phải sau ngày bắt đầu");
        }
        if (bindingResult.hasErrors()) {
            return "add_form";
        }
        Promotion promotion = new Promotion();
        BeanUtils.copyProperties(promotionDTO, promotion);
        promotionService.addPromotion(promotion);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!");
        return "redirect:/";
    }

    @PostMapping("delete-promotion/{id}")
    public String deletePromotion(@PathVariable("id") int id,
                                  RedirectAttributes redirectAttributes) {
        promotionService.deletePromotionById(id);
        redirectAttributes.addFlashAttribute("message", "Đã xóa thành công!");
        return "redirect:/";
    }
}
