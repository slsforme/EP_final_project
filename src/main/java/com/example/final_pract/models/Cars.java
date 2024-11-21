package com.example.final_pract.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 100)
    private String make;

    @NotNull
    @Size(max = 255)
    private String model;

    @NotNull
    private LocalDate year;

    @NotNull
    private Double price;

    @ManyToOne
    @JoinColumn(name = "dealer_id", nullable = false)
    private Dealers dealer;

    // Getter and Setter methods

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    @Size(max = 100)
    public String getMake() {
        return make;
    }

    public void setMake(@NotNull @Size(max = 100) String make) {
        this.make = make;
    }

    @NotNull
    @Size(max = 255)
    public String getModel() {
        return model;
    }

    public void setModel(@NotNull @Size(max = 255) String model) {
        this.model = model;
    }

    @NotNull
    public LocalDate getYear() {
        return year;
    }

    public void setYear(@NotNull LocalDate year) {
        this.year = year;
    }

    @NotNull
    public Double getPrice() {
        return price;
    }

    public void setPrice(@NotNull Double price) {
        this.price = price;
    }

    public Dealers getDealer() {
        return dealer;
    }

    public void setDealer(Dealers dealer) {
        this.dealer = dealer;
    }
}
