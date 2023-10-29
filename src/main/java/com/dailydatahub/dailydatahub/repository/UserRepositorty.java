package com.dailydatahub.dailydatahub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailydatahub.dailydatahub.domain.User;

public interface UserRepositorty extends JpaRepository<User, Long>{

    Optional<User> findById(String id);

    Optional<User> findByIdAndNameAndEmail(String id, String name, String email);
    
}
