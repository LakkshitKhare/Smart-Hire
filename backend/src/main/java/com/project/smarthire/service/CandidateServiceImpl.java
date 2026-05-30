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
    public String addDetails (CandidateProfileDTO candidateProfileDTO) throws SmartHireException{
       CandidateProfile candidate = candidateRepository.findByEmail(candidateProfileDTO.getEmail());
       if(candidate==null){
        throw new SmartHireException("Service.CANDIDATE_NOT_FOUND");
       }
       CandidateProfile updateCandidate = modelMapper.map(candidateProfileDTO,CandidateProfile.class);
       return "Data Saved Successfully for "+updateCandidate.getFullName();
    }

    @Override
    public CandidateProfileDTO getDetails(String email) throws SmartHireException {
        CandidateProfile candidate = candidateRepository.findByEmail(email);
        if(candidate == null){
            throw new SmartHireException("Service.CANDIDATE_NOT_FOUND");
        }
        return modelMapper.map(candidate,CandidateProfileDTO.class);

    }



}
