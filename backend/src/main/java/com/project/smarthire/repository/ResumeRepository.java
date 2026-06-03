package com.project.smarthire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.smarthire.entity.Resume;


public interface ResumeRepository extends JpaRepository<Resume, Long> {

    List<Resume> findByCandidate_ProfileId(Long profileId);

    Long countByCandidate_ProfileId(Long profileId);
    
}
