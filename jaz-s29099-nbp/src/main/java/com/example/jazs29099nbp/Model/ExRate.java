package com.example.jazs29099nbp.Model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public class ExRate {

    @Schema(description = "Effective date", example = "2024-06-28")
    private LocalDate effectiveDate;

    @Schema(description = "Price rate", example = "4.4813")
    private double price;



    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double mid) {
        this.price = mid;
    }
}
