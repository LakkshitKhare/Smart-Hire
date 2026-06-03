package com.project.smarthire.dto;

import java.time.LocalDateTime;

import com.project.smarthire.entity.CandidateProfile;

import lombok.Data;

@Data
public class ResumeDTO {

    private Long resumeId;
    private String resumeName;
    private LocalDateTime uploadTime;
    private String resumeUrl;
    private CandidateProfile candidate;

}
