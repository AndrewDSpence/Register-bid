package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.ResponseData;
import com.example.easynotes.model.User;
import com.example.easynotes.model.LoginRequest;
import com.example.easynotes.model.ResponseData;
import com.example.easynotes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by andrewdspence on 7/01/23.
 */

@RestController
@CrossOrigin(origins = "http://192.168.104.99:3000")
@RequestMapping("/api")
public class UserController{

    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "/user")
    public ResponseData getAllUser() {
        return new ResponseData("200","Success", userRepository.findAll());
    }

//    @PostMapping("/user")
//    public ResponseData createUser(@Valid @RequestBody User user) {
//        try{
//            User data =  userRepository.save(user);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new ResponseData("200","Success",user);
//    }

//    @GetMapping("/user/{id}")
//    public User getUserById(@PathVariable(value = "id") Long userId) {
//        return userRepository.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
//    }

//    @PutMapping("/user/{id}")
//    public User updateUser(@PathVariable(value = "id") Long userId,
//                           @Valid @RequestBody User userDetails) {
//        User user= userRepository.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
//        if(userDetails.getUser_password().equals(user.getUser_password())){
//            user.setUser_password(userDetails.getUser_password());
//        }
////        user.setEmail(userDetails.getEmail());
////        user.setUser_name(userDetails.getUser_name());
//
//        User updatedUser = userRepository.save(user);
//        return updatedUser;
//    }

//    @DeleteMapping("/user/{id}")
//    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long userId) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
//
//        userRepository.delete(user);
//
//        return ResponseEntity.ok().build();
//    }
}
