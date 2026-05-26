package com.project.smarthire.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.smarthire.dto.CandidateProfileDTO;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("api/candidate")
@CrossOrigin(origins = "*")
public class CandidateAPI {

    @PutMapping("/save")
    public String updateProfile(@RequestBody CandidateProfileDTO dto){
        return null;
    }

}
