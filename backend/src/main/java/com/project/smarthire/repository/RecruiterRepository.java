
package com.project.smarthire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.smarthire.entity.Recruiter;


public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {

    Recruiter findByUser_Email(String email);
}
