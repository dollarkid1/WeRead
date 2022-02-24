package com.example.simpleform.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "users_table")
@Entity
@Data
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String login;

    private String password;

    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUser)) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(Id, appUser.Id) && Objects.equals(login, appUser.login) && Objects.equals(password, appUser.password) && Objects.equals(email, appUser.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, login, password, email);
    }


    @Override
    public String toString() {
        return "AppUser{" +
                "Id=" + Id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
