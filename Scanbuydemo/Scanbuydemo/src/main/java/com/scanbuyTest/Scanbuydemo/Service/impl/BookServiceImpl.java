package com.scanbuyTest.Scanbuydemo.Service.impl;

import jakarta.transaction.Transactional;
import com.scanbuyTest.Scanbuydemo.model.Book;
import com.scanbuyTest.Scanbuydemo.Repository.BookRepository;
import com.scanbuyTest.Scanbuydemo.Service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /// The functionality will return all books from the database
    @Override
    public ResponseEntity<Object> books() {
        List<Book> bk = bookRepository.findAll();
        Map<String, Object> hm = new HashMap<>();
        hm.put("response", bk);
        hm.put("status", 200);
        HttpStatus httpStatus = HttpStatus.OK;
        return new ResponseEntity<>(hm, httpStatus);

    }

    // The functionality takes the ISBN as a input and it will retutn the Book
    public ResponseEntity<Object> book(String ISBN) {

        Book bk = (bookRepository.ISBN(ISBN));
        Map<String, Object> hm = new HashMap<>();
        hm.put("response", bk);
        hm.put("status", 200);
        HttpStatus httpStatus = HttpStatus.OK;
        return new ResponseEntity<>(hm, httpStatus);
    }

    // here the functionality will add the book to a database , when the
    // searched book is not found in database it takes from the google APi and will
    // add to the database
    @Override
    public ResponseEntity<Object> bookAdd(Map<String, String> body) {
        Map<String, Object> hm = new HashMap<>();
        Book bk = new Book();
        bk.setBookAuthor(body.get("author"));
        bk.setBookName(body.get("title"));
        bk.setBookpage(Integer.parseInt(body.get("pages")));
        bk.setISBN(body.get("ISBN"));
        bookRepository.save(bk);
        hm.put("response", bk);
        hm.put("status", 200);
        HttpStatus httpStatus = HttpStatus.OK;
        return new ResponseEntity<>(hm, httpStatus);
    }

    // Here this functionality is used update the book details,
    // ISBN cannot get updated since it is aunique value , which cannot update

    public ResponseEntity<Object> bookUpdate(Map<String, String> body, String ISBN) {
        // int value = Integer.parseInt(ISBN);
        Book bk = (bookRepository.ISBN(ISBN));
        Map<String, Object> hm = new HashMap<>();

        if (body.get("author") != null) {
            bk.setBookAuthor(body.get("author"));
        }
        if (body.get("title") != null) {
            bk.setBookName(body.get("title"));
        }
        if (body.get("Pages") != null) {
            bk.setBookpage(Integer.parseInt(body.get("Pages")));
        }
        Book newbk = (bookRepository.ISBN(ISBN));

        bookRepository.save(bk);
        hm.put("response", newbk);
        hm.put("status", 200);
        HttpStatus httpStatus = HttpStatus.OK;
        return new ResponseEntity<>(hm, httpStatus);

    }

    // here the functionality is used todelete a book from the database.
    @Transactional
    public ResponseEntity<Object> bookDelete(String ISBN) {
        Map<String, Object> hm = new HashMap<>();
        bookRepository.deleteByISBN(ISBN);
        hm.put("response", "BookDeletedSuccefuly");
        hm.put("status", 200);
        HttpStatus httpStatus = HttpStatus.OK;
        return new ResponseEntity<>(hm, httpStatus);
    }

}
