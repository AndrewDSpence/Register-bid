package com.example.easynotes.controller;

import com.example.easynotes.model.LoginRequest;
import com.example.easynotes.model.ResponseData;
import com.example.easynotes.model.User;
import com.example.easynotes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class AuthController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ResponseData Login(@Valid @RequestBody LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail()) ;
        if (user != null) {
            return new ResponseData("200", "Success", user);
        } else {
            return new ResponseData("407", "No Exist");
        }
    }
}
