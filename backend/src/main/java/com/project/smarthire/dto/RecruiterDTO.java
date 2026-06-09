package com.project.smarthire.dto;

import com.project.smarthire.entity.User;

import lombok.Data;

@Data

public class RecruiterDTO {

    private String companyName;
    private String recruiterName;
    private String designation;
    private String companyWebsite;
    private String companyLocation;

    private User user;

}
