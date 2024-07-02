package com.example.jazs29099nbp.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;

@Entity
public class GoldPriceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id of currency rate record.", required = true)
    private Integer id;

    @Schema(description = "type of metal", required = true)
    @Enumerated(EnumType.STRING)
    private TypeOfMetal metal;

    @Schema(description = "Start of interval used to calculate rate", required = true)
    @Column(name="start_date")
    private LocalDate startDate;

    @Schema(description = "End of interval used to calculate rate", required = true)
    @Column(name="end_date")
    private LocalDate endDate;

    @Schema(description = "Sum of exchange rates divided by amount of days", required = true)
    @Column(name="rate")
    private Double rate;

    @Schema(description = "Date and time of request", required = true)
    private Instant created;


    public GoldPriceRecord(Integer id, TypeOfMetal metal, LocalDate startDate, LocalDate endDate, Double rate, Instant created) {
        this.id = id;
        this.metal = metal;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rate = rate;
        this.created = created;
    }
    public GoldPriceRecord(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TypeOfMetal getMetal() {
        return metal;
    }

    public void setMetal(TypeOfMetal metal) {
        this.metal = metal;
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

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }
}
