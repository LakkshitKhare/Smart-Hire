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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.smarthire.dto.ResumeDTO;
import com.project.smarthire.exception.SmartHireException;
import com.project.smarthire.service.ResumeService;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin(origins= "*")
public class ResumeAPI {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadResume(
            @RequestParam("file") MultipartFile file,
            @RequestParam("email") String email)
            throws SmartHireException {

        String message
                = resumeService.uploadResume(
                        file,
                        email);

        return new ResponseEntity<>(
                message,
                HttpStatus.OK);
    }

    @GetMapping("/my-resumes/{email}")
    public ResponseEntity<List<ResumeDTO>>
            getMyResumes(
                    @PathVariable String email)
            throws SmartHireException {

        List<ResumeDTO> resumes
                = resumeService.getMyResumes(
                        email);

        return new ResponseEntity<>(
                resumes,
                HttpStatus.OK);
    }

    @DeleteMapping("/{resumeId}")
    public ResponseEntity<String>
            deleteResume(
                    @PathVariable Long resumeId)
            throws SmartHireException {

        String message
                = resumeService.deleteResume(
                        resumeId);

        return new ResponseEntity<>(
                message,
                HttpStatus.OK);
    }

}
