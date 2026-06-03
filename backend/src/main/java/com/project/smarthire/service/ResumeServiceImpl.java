package com.project.smarthire.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.smarthire.dto.ResumeDTO;
import com.project.smarthire.entity.CandidateProfile;
import com.project.smarthire.entity.Resume;
import com.project.smarthire.exception.SmartHireException;
import com.project.smarthire.repository.CandidateRepository;
import com.project.smarthire.repository.ResumeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ResumeServiceImpl
        implements ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Override
    public String uploadResume(
            MultipartFile file,
            String email)
            throws SmartHireException {

        CandidateProfile candidate
                = candidateRepository.findByEmail(email);

        if (candidate == null) {
            throw new SmartHireException(
                    "Candidate not found");
        }

        Long count
                = resumeRepository
                        .countByCandidate_ProfileId(
                                candidate.getProfileId());

        if (count >= 5) {
            throw new SmartHireException(
                    "Maximum 5 resumes allowed");
        }

        try {

            String originalName
                    = file.getOriginalFilename();

            String fileName
                    = UUID.randomUUID()
                    + "_" + originalName;

            Path path
                    = Paths.get(uploadDir, fileName);

            Files.createDirectories(
                    path.getParent());

            Files.copy(
                    file.getInputStream(),
                    path,
                    StandardCopyOption.REPLACE_EXISTING);

            Resume resume = new Resume();

            resume.setResumeName(originalName);

            resume.setResumeUrl(
                    "/resumes/" + fileName);

            resume.setUploadTime(
                    LocalDateTime.now());

            resume.setCandidate(candidate);

            resumeRepository.save(resume);

            return "Resume uploaded successfully";

        } catch (IOException e) {

            throw new SmartHireException(
                    "Resume upload failed");
        }
    }

    @Override
    public List<ResumeDTO> getMyResumes(
            String email)
            throws SmartHireException {

        CandidateProfile candidate
                = candidateRepository.findByEmail(email);

        if (candidate == null) {
            throw new SmartHireException(
                    "Candidate not found");
        }

        List<Resume> resumes
                = resumeRepository
                        .findByCandidate_ProfileId(
                                candidate.getProfileId());

        return resumes.stream()
                .map(resume
                        -> modelMapper.map(
                        resume,
                        ResumeDTO.class))
                .toList();
    }

    @Override
    public String deleteResume(
            Long resumeId)
            throws SmartHireException {

        Resume resume
                = resumeRepository.findById(resumeId)
                        .orElseThrow(()
                                -> new SmartHireException(
                                "Resume not found"));

        try {

            Path path
                    = Paths.get(
                            resume.getResumeUrl());

            Files.deleteIfExists(path);

        } catch (IOException e) {

            throw new SmartHireException(
                    "File delete failed");
        }

        resumeRepository.delete(resume);

        return "Resume deleted successfully";
    }
}
