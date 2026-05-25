package com.project.smarthire.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public String registerUser(UserDTO userDTO) {
        User user = userRepository.findByEmail(userDTO.getEmail());
        if(user == null){
            User newuser = modelMapper.map(userDTO, User.class);
            userRepository.save(newuser);
            return "User registered with email: "+userDTO.getEmail();
        }
        else{
            return "User already exists with email: "+userDTO.getEmail();
        }
    }

}
