package com.scanbuyTest.Scanbuydemo.Repository;

import com.scanbuyTest.Scanbuydemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.Id;

public interface UserRepository extends JpaRepository<User, Id> {
    User email(String email);
}
