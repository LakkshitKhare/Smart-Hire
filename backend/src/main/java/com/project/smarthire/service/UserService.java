package com.project.smarthire.service;

import com.project.smarthire.dto.LoginDTO;
import com.project.smarthire.dto.UserDTO;

public interface UserService {
    String registerUser(UserDTO userDTO);

    String loginUser(LoginDTO loginDTO);

}
