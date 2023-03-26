package com.scanbuyTest.Scanbuydemo.Service;

import java.util.List;
import java.util.Map;
import com.scanbuyTest.Scanbuydemo.model.Book;
import org.springframework.http.ResponseEntity;

public interface BookService {
    public ResponseEntity<Object> books();

    public ResponseEntity<Object> book(String ISBN);

    public ResponseEntity<Object> bookAdd(Map<String, String> body);

    public ResponseEntity<Object> bookDelete(String ISBN);

    public ResponseEntity<Object> bookUpdate(Map<String, String> body, String ISBN);

}