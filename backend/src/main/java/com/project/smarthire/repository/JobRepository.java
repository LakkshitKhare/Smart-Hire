package com.project.smarthire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.smarthire.entity.Job;

public interface JobRepository
        extends JpaRepository<Job, Long> {

    List<Job> findByRecruiter_RecruiterId(
            Long recruiterId);

    List<Job> findByStatus(
            String status);
}