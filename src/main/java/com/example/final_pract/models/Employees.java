package com.example.final_pract.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 100)
    private String firstName;

    @NotNull
    @Size(max = 100)
    private String secondName;

    @Size(max = 100)
    private String thirdName;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Roles role;

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
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull @Size(max = 100) String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    @Size(max = 100)
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(@NotNull @Size(max = 100) String secondName) {
        this.secondName = secondName;
    }

    @Size(max = 100)
    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(@Size(max = 100) String thirdName) {
        this.thirdName = thirdName;
    }

    @NotNull
    public Roles getRole() {
        return role;
    }

    public void setRole(@NotNull Roles role) {
        this.role = role;
    }

    public Dealers getDealer() {
        return dealer;
    }

    public void setDealer(Dealers dealer) {
        this.dealer = dealer;
    }
}

