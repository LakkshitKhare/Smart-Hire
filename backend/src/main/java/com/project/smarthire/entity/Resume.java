package com.project.smarthire.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Resume {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long resumeId;
    private String resumeName;
    private LocalDateTime uploadTime;
    private String resumeUrl;

    @ManyToOne
    @JoinColumn(name="candidate_id")
    private CandidateProfile candidate;

}
