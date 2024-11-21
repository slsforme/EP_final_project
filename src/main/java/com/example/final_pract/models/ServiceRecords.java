package com.example.final_pract.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class ServiceRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Cars car;

    @NotNull
    private LocalDateTime serviceDate;

    @NotNull
    @Size(max = 100)
    private String description;

    @NotNull
    private Double cost;

    // Getter and Setter methods

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    public Cars getCar() {
        return car;
    }

    public void setCar(@NotNull Cars car) {
        this.car = car;
    }

    @NotNull
    public LocalDateTime getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(@NotNull LocalDateTime serviceDate) {
        this.serviceDate = serviceDate;
    }

    @NotNull
    @Size(max = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(@NotNull @Size(max = 100) String description) {
        this.description = description;
    }

    @NotNull
    public Double getCost() {
        return cost;
    }

    public void setCost(@NotNull Double cost) {
        this.cost = cost;
    }
}
