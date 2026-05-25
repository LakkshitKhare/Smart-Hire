package com.project.smarthire.service;

import com.project.smarthire.dto.LoginDTO;
import com.project.smarthire.dto.UserDTO;
import com.project.smarthire.exception.SmartHireException;

public interface UserService {
    String registerUser(UserDTO userDTO) throws  SmartHireException;

    String loginUser(LoginDTO loginDTO) throws SmartHireException; 

}
