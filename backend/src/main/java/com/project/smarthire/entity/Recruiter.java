package com.project.smarthire.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Recruiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recruiterId;

    private String companyName;
    private String recruiterName;
    private String designation;
    private String companyWebsite;
    private String companyLocation;
    
    @JoinColumn(name = "user_id")
    @OneToOne
    private User user;

}
