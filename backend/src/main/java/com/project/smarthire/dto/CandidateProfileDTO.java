package com.project.smarthire.dto;

import lombok.Data;

@Data
public class CandidateProfileDTO {

    private String fullName;
    private String phone;
    private String location;
    private String linkedinUrl;
    private String githubUrl;
    private String skills;
    private Integer experienceYears;
    private String education;
}
