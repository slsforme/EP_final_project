package com.example.final_pract.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Cars car;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customer;

    @ManyToOne
    @JoinColumn(name = "dealer_id", nullable = false)
    private Dealers dealer;

    @NotNull
    private LocalDate saleDate;

    @NotNull
    private Double finalPrice;

    // Конструктор без аргументов
    public Sales() {
    }

    // Конструктор с аргументами
    public Sales(Cars car, Customers customer, Dealers dealer, LocalDate saleDate, Double finalPrice) {
        this.car = car;
        this.customer = customer;
        this.dealer = dealer;
        this.saleDate = saleDate;
        this.finalPrice = finalPrice;
    }

    // Геттеры и сеттеры
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cars getCar() {
        return car;
    }

    public void setCar(Cars car) {
        this.car = car;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Dealers getDealer() {
        return dealer;
    }

    public void setDealer(Dealers dealer) {
        this.dealer = dealer;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }
}
