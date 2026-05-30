package com.project.smarthire.dto;

import lombok.Data;


@Data
public class CandidateProfileDTO {

    private String fullName;
    private String mobile;
    private String email;
    private String location;
    private String linkedinUrl;
    private String githubUrl;
    private String skills;
    private Integer experienceInYears;
    private String resumeUrl;
    private String education;

}
