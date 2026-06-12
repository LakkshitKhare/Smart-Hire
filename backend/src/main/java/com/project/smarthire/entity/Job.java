package com.project.smarthire.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    private String jobTitle;

    private String companyName;

    private String location;

    private String jobType;

    private Integer experienceRequired;

    private Double salaryMin;

    private Double salaryMax;

    @Column(length = 1000)
    private String requiredSkills;

    @Column(length = 5000)
    private String description;

    private Integer vacancies;

    private LocalDate applicationDeadline;

    private LocalDateTime postedDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    private Recruiter recruiter;  

}
    