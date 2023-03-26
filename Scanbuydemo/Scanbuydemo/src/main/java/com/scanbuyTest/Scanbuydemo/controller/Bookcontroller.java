
package com.scanbuyTest.Scanbuydemo.controller;

import java.util.*;
import com.scanbuyTest.Scanbuydemo.Service.BookService;
import com.scanbuyTest.Scanbuydemo.model.Book;
import com.scanbuyTest.Scanbuydemo.response.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;

@RestController

public class Bookcontroller {

    private BookService service;

    @Autowired
    public void BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/books")
    public ResponseEntity<Object> books() {
        return service.books();

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/book/{ISBN}")
    public ResponseEntity<Object> book(@PathVariable String ISBN) {
        return service.book(ISBN);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/book/add")
    public ResponseEntity<Object> bookAdd(@RequestBody Map<String, String> body) {
        return service.bookAdd(body);

    }

    @PutMapping("/book/update")
    public ResponseEntity<Object> bookUpdate(@RequestBody Map<String, String> body) {
        return service.bookUpdate(body, body.get("ISBN"));
    }

    @DeleteMapping("/book/delete/{ISBN}")
    public ResponseEntity<Object> bookDelete(@PathVariable String ISBN) {
        return service.bookDelete(ISBN);
    }

}
