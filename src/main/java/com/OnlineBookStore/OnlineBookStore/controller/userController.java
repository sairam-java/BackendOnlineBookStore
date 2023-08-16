package com.OnlineBookStore.OnlineBookStore.controller;

import com.OnlineBookStore.OnlineBookStore.payload.userDto;
import com.OnlineBookStore.OnlineBookStore.payload.userResponse;
import com.OnlineBookStore.OnlineBookStore.serviceImpl.userImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class userController {

    @Autowired
    private userImpl userImpl;

    @PostMapping("/")
    public ResponseEntity<userResponse> createUser(@RequestBody userDto userDto){
        userResponse user = userImpl.createUser(userDto);
        return new ResponseEntity<userResponse>(user, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<userResponse> getUserById(@PathVariable Long userId){
        userResponse userDetails = userImpl.getUserById(userId);
        return new ResponseEntity<userResponse>(userDetails, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<userResponse>> getAllUsers(){
        List<userResponse> allUsers = userImpl.getAllusers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        String statusOfDeletion = userImpl.deleteUser(userId);
        return new ResponseEntity<String>(statusOfDeletion, HttpStatus.OK);
    }
}
