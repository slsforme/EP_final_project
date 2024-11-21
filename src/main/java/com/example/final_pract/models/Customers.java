package com.example.final_pract.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 100)
    private String firstName;

    @NotNull
    @Size(max = 100)
    private String lastName;

    @NotNull
    @Size(max = 100)
    private String phoneNumber;

    @NotNull
    @Size(max = 255)
    private String email;

    // Getter and Setter methods

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    @Size(max = 100)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull @Size(max = 100) String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    @Size(max = 100)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull @Size(max = 100) String lastName) {
        this.lastName = lastName;
    }

    @NotNull
    @Size(max = 100)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotNull @Size(max = 100) String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @NotNull
    @Size(max = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @Size(max = 255) String email) {
        this.email = email;
    }
}
