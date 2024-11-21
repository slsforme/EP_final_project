package com.example.final_pract.models;

import jakarta.persistence.*;

@Entity
public class CarFeatureMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "feature_id", nullable = false)
    private CarFeatures feature;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Cars car;

    // Getter and Setter methods

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CarFeatures getFeature() {
        return feature;
    }

    public void setFeature(CarFeatures feature) {
        this.feature = feature;
    }

    public Cars getCar() {
        return car;
    }

    public void setCar(Cars car) {
        this.car = car;
    }
}
