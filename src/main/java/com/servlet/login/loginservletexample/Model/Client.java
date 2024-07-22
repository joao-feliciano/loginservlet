package com.servlet.login.loginservletexample.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Client {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String email;

    @ToString.Exclude
    @Column(length = 50)
    private String password;

    public Client(String nome) {
        this.name = nome;
    }

    public Client(String email, String password) {
        this.password = password;
        this.email = email;
    }

    public Client(String name, String email, String password) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
