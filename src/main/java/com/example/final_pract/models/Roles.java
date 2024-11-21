package com.example.final_pract.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Set;

@Entity
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = true)
    @Size(max = 1000)
    private String description;

    @OneToMany(mappedBy = "role")
    private List<User> users;

    // Конструкторы, геттеры и сеттеры
    public Roles() {}

    public Roles(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
