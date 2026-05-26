package com.project.smarthire.service;

import com.project.smarthire.dto.CandidateProfileDTO;
import com.project.smarthire.exception.SmartHireException;

public interface CandidateService {

    String addDetails(CandidateProfileDTO candidateProfileDTO) throws SmartHireException;

}
