/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.project.smarthire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.smarthire.dto.JobDTO;
import com.project.smarthire.exception.SmartHireException;
import com.project.smarthire.service.JobService;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin("*")
public class JobAPI {

    @Autowired
    private JobService jobService;

    @PostMapping
    public ResponseEntity<String>
    createJob(
            @RequestBody JobDTO dto)
            throws SmartHireException {

        return new ResponseEntity<>(
                jobService.createJob(dto),
                HttpStatus.CREATED);
    }

    @GetMapping("/recruiter/{email}")
    public ResponseEntity<List<JobDTO>>
    getRecruiterJobs(
            @PathVariable String email)
            throws SmartHireException {

        return ResponseEntity.ok(
                jobService.getRecruiterJobs(
                        email));
    }

    @GetMapping
    public ResponseEntity<List<JobDTO>>
    getAllOpenJobs() {

        return ResponseEntity.ok(
                jobService.getAllOpenJobs());
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<JobDTO>
    getJobById(
            @PathVariable Long jobId)
            throws SmartHireException {

        return ResponseEntity.ok(
                jobService.getJobById(jobId));
    }

    @DeleteMapping("/{jobId}")
    public ResponseEntity<String>
    deleteJob(
            @PathVariable Long jobId)
            throws SmartHireException {

        return ResponseEntity.ok(
                jobService.deleteJob(jobId));
    }
}
