package com.example.tokenauthenticate.repository;

import com.example.tokenauthenticate.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
        Optional<User> findByUserName(String name);
}
