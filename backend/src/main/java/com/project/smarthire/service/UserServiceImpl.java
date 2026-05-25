package com.project.smarthire.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.smarthire.dto.LoginDTO;
import com.project.smarthire.dto.UserDTO;
import com.project.smarthire.entity.User;
import com.project.smarthire.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    ModelMapper modelMapper = new ModelMapper();

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public String registerUser(UserDTO userDTO) {
        User user = userRepository.findByEmail(userDTO.getEmail());
        if (user == null) {
            User newuser = modelMapper.map(userDTO, User.class);
            newuser.setPasswordHash(encoder.encode(userDTO.getPasswordHash()));
            userRepository.save(newuser);
            return "User registered with email: " + userDTO.getEmail();
        } else {
            return "User already exists with email: " + userDTO.getEmail();
        }
    }

    @Override
    public String loginUser(LoginDTO loginDTO){
        User user = userRepository.findByEmail(loginDTO.getEmail());
        if(user == null){
            return "Invalid Credentials";
        }
        if(!encoder.matches(loginDTO.getPassword(), user.getPasswordHash())){
            return "Invalid Credentials";
        }
        return "Login Success";
    }

}
