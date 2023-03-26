package com.scanbuyTest.Scanbuydemo.Repository;

import com.scanbuyTest.Scanbuydemo.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.persistence.Id;

public interface BookRepository extends JpaRepository<Book, Id> {
    String deleteByISBN(String ISBN);

    Book ISBN(String ISBN);

}
