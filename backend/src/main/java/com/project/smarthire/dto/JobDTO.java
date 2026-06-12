package com.project.smarthire.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class JobDTO {

    private Long jobId;

    private String jobTitle;

    private String companyName;

    private String location;

    private String jobType;

    private Integer experienceRequired;

    private Double salaryMin;

    private Double salaryMax;

    private String requiredSkills;

    private String description;

    private Integer vacancies;

    private LocalDate applicationDeadline;

    private String status;

    private String recruiterEmail;
}