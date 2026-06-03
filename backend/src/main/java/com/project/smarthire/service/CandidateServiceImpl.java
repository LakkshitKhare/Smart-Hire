package com.project.smarthire.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.smarthire.dto.CandidateProfileDTO;
import com.project.smarthire.entity.CandidateProfile;
import com.project.smarthire.exception.SmartHireException;
import com.project.smarthire.repository.CandidateRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public String addDetails(
            CandidateProfileDTO dto)
            throws SmartHireException {

        CandidateProfile candidate
                = candidateRepository.findByEmail(
                        dto.getEmail());

        if (candidate == null) {
            throw new SmartHireException(
                    "Candidate not found");
        }

        candidate.setFullName(dto.getFullName());
        candidate.setMobile(dto.getMobile());
        candidate.setEmail(dto.getEmail());
        candidate.setLocation(dto.getLocation());
        candidate.setLinkedinUrl(dto.getLinkedinUrl());
        candidate.setGithubUrl(dto.getGithubUrl());
        candidate.setSkills(dto.getSkills());
        candidate.setEducation(dto.getEducation());

        if (dto.getExperienceInYears() != null) {
            candidate.setExperienceInYears(
                    dto.getExperienceInYears());
        }

        candidateRepository.save(candidate);

        return "Updated Successfully";
    }

    @Override
    public CandidateProfileDTO getDetails(String email) throws SmartHireException {
        CandidateProfile candidate = candidateRepository.findByEmail(email);
        if (candidate == null) {
            throw new SmartHireException("Service.CANDIDATE_NOT_FOUND");
        }
        return modelMapper.map(candidate, CandidateProfileDTO.class);

    }

}
