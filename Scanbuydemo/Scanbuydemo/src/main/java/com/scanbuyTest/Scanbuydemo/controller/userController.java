package com.scanbuyTest.Scanbuydemo.controller;

import com.scanbuyTest.Scanbuydemo.Service.UserService;
import com.scanbuyTest.Scanbuydemo.model.User;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;

@RestController
public class userController {

    private UserService userservice;

    @Autowired
    public userController(UserService userservice) {
        this.userservice = userservice;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/signUp")
    public ResponseEntity<Object> signUp(@RequestBody Map<String, String> body) {
        System.out.println("controller" + body);
        return userservice.signUp(body);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody Map<String, String> body) {
        return userservice.login(body);

    }

}
