package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.LoginRequest;
import com.example.easynotes.model.ResponseData;
import com.example.easynotes.model.User;
import com.example.easynotes.repository.UserRepository;
import org.hibernate.validator.internal.util.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.util.logging.Logger;


@RestController
@CrossOrigin(origins = "http://192.168.104.109:3000")
@RequestMapping("/api")
public class AuthController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ResponseData Login(@Valid LoginRequest loginRequest){
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(()->new ResourceNotFoundException("User", "email", loginRequest.getEmail()));
        return new ResponseData("200","Success",user);
    }

}
