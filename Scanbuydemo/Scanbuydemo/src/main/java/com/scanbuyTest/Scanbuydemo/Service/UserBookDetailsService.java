package com.scanbuyTest.Scanbuydemo.Service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface UserBookDetailsService {

    public ResponseEntity<Object> userBookNotes(Map<String, String> body);

    public ResponseEntity<Object> userBookRead(Map<String, String> body);

    public ResponseEntity<Object> userBookDelete(Map<String, String> body);

    public ResponseEntity<Object> userBookAdd(Map<String, String> body);

    public ResponseEntity<Object> userBook(String email, String ISBN);

    public ResponseEntity<Object> userBooks(String body);
}
