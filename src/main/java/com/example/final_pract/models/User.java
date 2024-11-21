package com.example.final_pract.models;

import jakarta.persistence.*;

@Entity
@Table(name="user", schema="public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // Идентификатор пользователя

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)

    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Roles role; // У каждого пользователя одна роль

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
