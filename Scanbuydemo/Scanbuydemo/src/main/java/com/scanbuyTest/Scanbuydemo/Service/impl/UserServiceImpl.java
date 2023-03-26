package com.scanbuyTest.Scanbuydemo.Service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.scanbuyTest.Scanbuydemo.Service.UserService;
import com.scanbuyTest.Scanbuydemo.model.User;
import com.scanbuyTest.Scanbuydemo.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.Map;
import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {

    UserRepository user;

    public UserServiceImpl(UserRepository user) {
        this.user = user;
    }

    // here the functionality is used to signup, if the user is already
    // present in the database it will throw error .
    @Override
    public ResponseEntity<Object> signUp(Map<String, String> body) {
        System.out.println("body inside the service imp" + body);
        User us = new User();
        us.setfirstName(body.get("firstName"));
        us.setlastName(body.get("lastName"));
        us.setemail(body.get("email"));
        us.setpassword(body.get("password"));
        try {

            user.save(us);
            Map<String, Object> hm = new HashMap<>();
            hm.put("created", true);
            hm.put("email", us.getEmail());
            hm.put("status", 200);
            System.out.println(hm);
            HttpStatus httpStatus = HttpStatus.OK;
            return new ResponseEntity<>(hm, httpStatus);

        } catch (Exception e) {
            Map<String, Object> hm = new HashMap<>();
            hm.put("created", false);
            hm.put("response", "Either Database failed or User Already Exists");
            hm.put("status", 200);
            HttpStatus httpStatus = HttpStatus.OK;
            return new ResponseEntity<>(hm, httpStatus);

        }

    }

    // here the login is checked if password , is matched with the data base ,it
    // will login
    // else it will throw a error

    @Override
    public ResponseEntity<Object> login(Map<String, String> body) {
        System.out.println(body);
        User us = (user.email(body.get("email")));
        if (us != null && us.getpassword().equals(body.get("password"))) {

            Map<String, Object> hm = new HashMap<>();
            hm.put("email", us.getEmail());
            hm.put("response", "Logged succefully");
            hm.put("status", 200);
            HttpStatus httpStatus = HttpStatus.OK;
            return new ResponseEntity<>(hm, httpStatus);

        } else {
            Map<String, Object> hm = new HashMap<>();
            hm.put("response", "Either Database failed or User Already Exists");
            hm.put("status", 400);
            HttpStatus httpStatus = HttpStatus.OK;
            return new ResponseEntity<>(hm, httpStatus);
        }
    }

}
