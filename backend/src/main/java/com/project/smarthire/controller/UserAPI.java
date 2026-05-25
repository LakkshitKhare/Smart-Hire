package com.project.smarthire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.smarthire.dto.UserDTO;
import com.project.smarthire.service.UserService;


@RestController
@RequestMapping("api/users")
public class UserAPI {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO dto){
        System.out.println(dto.getEmail());
        String message = userService.registerUser(dto);
        return new ResponseEntity<>(message,HttpStatus.CREATED);
    }
}
