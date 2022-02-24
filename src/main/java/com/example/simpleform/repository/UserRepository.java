package com.example.simpleform.repository;

import com.example.simpleform.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {


    Optional<AppUser> findByLoginAndPassword(String login, String password);
}
