package com.example.module4exam.model;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class PromotionDTO {
    private int id;

    @NotBlank(message = "Nhập tiêu đề khuyến mãi!")
    private String title;

    @NotNull(message = "Nhập thời gian bắt đầu!")
    @FutureOrPresent(message = "Thời gian bắt đầu phải từ hôm nay!")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;

    @NotNull(message = "Nhập thời gian kết thúc!")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;

    @NotNull(message = "Nhập mức giảm giá")
    @Min(value = 10000, message = "Giảm giá phải từ 10.000 VND")
    private Double amount;

    @NotBlank(message = "Nhập chi tiết khuyến mãi")
    private String description;

    public PromotionDTO() {
    }

    public PromotionDTO(String title, LocalDate startDate, LocalDate endDate, Double amount, String description) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.description = description;
    }

    public PromotionDTO(int id, String title, LocalDate startDate, LocalDate endDate, Double amount, String description) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
