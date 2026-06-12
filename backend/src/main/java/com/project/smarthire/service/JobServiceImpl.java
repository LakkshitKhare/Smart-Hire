package com.project.smarthire.service;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.smarthire.dto.JobDTO;
import com.project.smarthire.entity.Job;
import com.project.smarthire.entity.Recruiter;
import com.project.smarthire.exception.SmartHireException;
import com.project.smarthire.repository.JobRepository;
import com.project.smarthire.repository.RecruiterRepository;

@Service
public class JobServiceImpl
        implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private RecruiterRepository recruiterRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public String createJob(JobDTO dto)
            throws SmartHireException {

        Recruiter recruiter
                = recruiterRepository.findByUser_Email(
                        dto.getRecruiterEmail());

        if (recruiter == null) {
            throw new SmartHireException(
                    "Recruiter not found");
        }

        Job job
                = modelMapper.map(dto, Job.class);

        job.setRecruiter(recruiter);

        job.setCompanyName(
                recruiter.getCompanyName());

        job.setPostedDate(
                LocalDateTime.now());

        job.setStatus("OPEN");

        jobRepository.save(job);

        return "Job Posted Successfully";
    }

    @Override
    public List<JobDTO> getRecruiterJobs(
            String email)
            throws SmartHireException {

        Recruiter recruiter
                = recruiterRepository.findByUser_Email(
                        email);

        if (recruiter == null) {
            throw new SmartHireException(
                    "Recruiter not found");
        }

        return jobRepository
                .findByRecruiter_RecruiterId(
                        recruiter.getRecruiterId())
                .stream()
                .map(job
                        -> modelMapper.map(
                        job,
                        JobDTO.class))
                .toList();
    }

    @Override
    public List<JobDTO> getAllOpenJobs() {

        return jobRepository
                .findByStatus("OPEN")
                .stream()
                .map(job
                        -> modelMapper.map(
                        job,
                        JobDTO.class))
                .toList();
    }

    @Override
    public JobDTO getJobById(
            Long jobId)
            throws SmartHireException {

        Job job
                = jobRepository.findById(jobId)
                        .orElseThrow(()
                                -> new SmartHireException(
                                "Job not found"));

        return modelMapper.map(
                job,
                JobDTO.class);
    }

    @Override
    public String deleteJob(
            Long jobId)
            throws SmartHireException {

        Job job
                = jobRepository.findById(jobId)
                        .orElseThrow(()
                                -> new SmartHireException(
                                "Job not found"));

        jobRepository.delete(job);

        return "Job Deleted Successfully";
    }
}
