package com.project.smarthire.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.smarthire.dto.LoginDTO;
import com.project.smarthire.dto.UserDTO;
import com.project.smarthire.entity.CandidateProfile;
import com.project.smarthire.entity.Recruiter;
import com.project.smarthire.entity.Role;
import com.project.smarthire.entity.User;
import com.project.smarthire.exception.SmartHireException;
import com.project.smarthire.repository.CandidateRepository;
import com.project.smarthire.repository.RecruiterRepository;
import com.project.smarthire.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    RecruiterRepository recruiterRepository;

    ModelMapper modelMapper = new ModelMapper();

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public String registerUser(UserDTO userDTO) throws SmartHireException {
        User user = userRepository.findByEmail(userDTO.getEmail());
        if (user == null) {
            User newuser = modelMapper.map(userDTO, User.class);
            newuser.setPassword(encoder.encode(userDTO.getPassword()));
            User savedUser = userRepository.save(newuser);
            if (savedUser.getRole() == Role.CANDIDATE) {
                CandidateProfile candidateProfile = new CandidateProfile();
                candidateProfile.setFullName(savedUser.getName());
                candidateProfile.setEmail(savedUser.getEmail());
                candidateProfile.setMobile(savedUser.getMobile());
                candidateProfile.setUser(savedUser);
                candidateRepository.save(candidateProfile);
            }
            else if(savedUser.getRole() == Role.RECRUITER){
                Recruiter recruiter = new Recruiter();
                recruiter.setRecruiterName(savedUser.getName());
                recruiter.setUser(savedUser);
                recruiterRepository.save(recruiter);
            }
            

            return "User registered with email: " + userDTO.getEmail();
        } else {
            throw new SmartHireException("Service.USER_ALREADY_EXISTS");
        }
    }

    @Override
    public String loginUser(LoginDTO loginDTO) throws SmartHireException {
        User user = userRepository.findByEmail(loginDTO.getEmail());
        if (user == null) {
            throw new SmartHireException("Service.INVALID_CREDENTIALS");
        }
        if (!encoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new SmartHireException("Service.INVALID_CREDENTIALS");
        }
        return ""+user.getRole();
    }

}
