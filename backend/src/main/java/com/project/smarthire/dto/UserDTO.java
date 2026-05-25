package com.project.smarthire.dto;

import com.project.smarthire.entity.Role;

import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String email;
    private Role role;
    private String passwordHash;
    private String telNumber;
    
}
