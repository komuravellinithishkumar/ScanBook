package com.scanbuyTest.Scanbuydemo.Repository;

import com.scanbuyTest.Scanbuydemo.model.*;

import java.util.Optional;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.persistence.Id;

public interface UserBookDetailsRepository extends JpaRepository<UserBookDetails, Id> {

    @Query("SELECT u FROM UserBookDetails u WHERE u.user = ?1 and u.book = ?2")
    public UserBookDetails findUserBookDetails(User user, Book book);

    @Query("SELECT u FROM UserBookDetails u WHERE u.user = ?1")
    public ArrayList<UserBookDetails> findAllBooksUser(User user);

    Long deleteByid(Long id);
}
