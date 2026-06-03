package com.project.smarthire.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.smarthire.dto.ResumeDTO;
import com.project.smarthire.exception.SmartHireException;

public interface ResumeService {

    String uploadResume(
            MultipartFile file,
            String email)
            throws SmartHireException;

    List<ResumeDTO> getMyResumes(
            String email)
            throws SmartHireException;

    String deleteResume(
            Long resumeId)
            throws SmartHireException;

}
