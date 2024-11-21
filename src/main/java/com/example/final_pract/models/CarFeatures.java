package com.example.final_pract.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class CarFeatures {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 255)
    private String name;

    // Getter and Setter methods

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    @Size(max = 255)
    public String getName() {
        return name;
    }

    public void setName(@NotNull @Size(max = 255) String name) {
        this.name = name;
    }
}
