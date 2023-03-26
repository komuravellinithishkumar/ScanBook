package com.scanbuyTest.Scanbuydemo.Service;

import java.util.Map;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<Object> signUp(Map<String, String> body);

    public ResponseEntity<Object> login(Map<String, String> body);

}
