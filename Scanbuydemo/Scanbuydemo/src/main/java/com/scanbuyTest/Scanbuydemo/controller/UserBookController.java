package com.scanbuyTest.Scanbuydemo.controller;

import com.scanbuyTest.Scanbuydemo.Service.UserBookDetailsService;
import com.scanbuyTest.Scanbuydemo.model.User;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserBookController {

  UserBookDetailsService UserBookDetailsService;

  public UserBookController(UserBookDetailsService UserBookDetailsService) {
    this.UserBookDetailsService = UserBookDetailsService;
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @PutMapping("/user/book/notes")
  public ResponseEntity<Object> userBookNotes(
      @RequestBody Map<String, String> body) {
    return UserBookDetailsService.userBookNotes(body);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @PutMapping("/user/book/read")
  public ResponseEntity<Object> userBookRead(
      @RequestBody Map<String, String> body) {
    return UserBookDetailsService.userBookRead(body);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @DeleteMapping("/user/book/delete")
  public ResponseEntity<Object> userBookDelete(
      @RequestBody Map<String, String> body) {
    return UserBookDetailsService.userBookDelete(body);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @PostMapping("/user/book/add")
  public ResponseEntity<Object> userBookAdd(
      @RequestBody Map<String, String> body) {
    return UserBookDetailsService.userBookAdd(body);
  }

  @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping("/user/book/{ISBN}/{email}")
  public ResponseEntity<Object> userBook(
      @PathVariable String email, @PathVariable String ISBN) {
    return UserBookDetailsService.userBook(email, ISBN);
  }

  @CrossOrigin
  @GetMapping("/user/books/{email}")
  public ResponseEntity<Object> userBooks(@PathVariable String email) {
    return UserBookDetailsService.userBooks(email);
  }

}
