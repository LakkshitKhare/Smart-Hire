package com.project.smarthire.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class CandidateProfile {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long profileId;
    private String fullName;
    private String mobile;
    private String email;
    private String location;
    private String linkedinUrl;
    private String githubUrl;
    private String skills;
    private Integer experienceInYears;
    private String education;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


}
