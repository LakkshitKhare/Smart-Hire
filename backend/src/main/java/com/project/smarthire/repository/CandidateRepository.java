package com.project.smarthire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.smarthire.entity.CandidateProfile;

public interface CandidateRepository extends JpaRepository<CandidateProfile, Long> {

    CandidateProfile findByEmail(String email);

}
