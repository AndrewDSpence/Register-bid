package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.LoginRequest;
import com.example.easynotes.model.ResponseData;
import com.example.easynotes.model.User;
import com.example.easynotes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody  ResponseData Login(@Valid @RequestBody LoginRequest loginRequest){
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(()->new ResourceNotFoundException("User", "email", loginRequest.getEmail()));
        return new ResponseData("200","Success",user);
    }
}
