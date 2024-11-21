package com.example.final_pract.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
public class Dealers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    @Size(max = 100)
    @Column(nullable = false)
    @Pattern(regexp = "^[78]\\d{10}$", message = "Invalid Russian phone number")
    private String contactNumber;

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

    @NotNull
    @Size(max = 100)
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(@NotNull @Size(max = 100) String contactNumber) {
        this.contactNumber = contactNumber;
    }
}


