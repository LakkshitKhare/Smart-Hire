package com.project.smarthire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.smarthire.dto.LoginDTO;
import com.project.smarthire.dto.UserDTO;
import com.project.smarthire.exception.SmartHireException;
import com.project.smarthire.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "*")
public class UserAPI {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserDTO dto) throws SmartHireException {
        String message = userService.registerUser(dto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDTO loginDTO) throws SmartHireException{
        String message = userService.loginUser(loginDTO);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
}
