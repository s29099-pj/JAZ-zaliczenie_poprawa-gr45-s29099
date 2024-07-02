package com.example.jazs29099nbp.Model;

import java.util.List;

public class GoldPriceRecordNbp {

    private TypeOfMetal metal;
    private TypeOfMetal metalType;
    private double averageRate;
    private List<ExRate> exRate;

    public GoldPriceRecordNbp(TypeOfMetal metal, String metalType, double averageRate, List<ExRate> exRate) {
        this.metal = metal;
        this.averageRate = averageRate;
        this.exRate = exRate;
    }

    public TypeOfMetal getMetal() {
        return metal;
    }

    public void setCurrency(TypeOfMetal metal) {
        this.metal = metal;
    }

    public TypeOfMetal getMetalType() {
        return metalType;
    }

    public void setMetalType(TypeOfMetal metalType) {
        this.metalType = metalType;
    }

    public double getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(double averageRate) {
        this.averageRate = averageRate;
    }

    public List<ExRate> getExRate() {
        return exRate;
    }

    public void setExRate(List<ExRate> exRate) {
        this.exRate = exRate;
    }
}
