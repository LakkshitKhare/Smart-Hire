package com.project.smarthire.service;

import java.util.List;

import com.project.smarthire.dto.JobDTO;
import com.project.smarthire.exception.SmartHireException;

public interface JobService {

    String createJob(JobDTO dto)
            throws SmartHireException;

    List<JobDTO> getRecruiterJobs(
            String email)
            throws SmartHireException;

    List<JobDTO> getAllOpenJobs();

    JobDTO getJobById(
            Long jobId)
            throws SmartHireException;

    String deleteJob(
            Long jobId)
            throws SmartHireException;
}