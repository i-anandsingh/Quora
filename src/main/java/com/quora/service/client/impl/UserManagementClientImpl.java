package com.quora.service.client.impl;

import com.quora.entity.UserEntity;
import com.quora.exceptionHandler.CustomException;
import com.quora.mapper.UserDetailsMapper;
import com.quora.repository.UserManagementRepository;
import com.quora.service.client.UserManagementClient;
import com.quora.service.models.request.UserDetailsInputDTO;
import com.quora.service.models.response.UserDetailsOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserManagementClientImpl implements UserManagementClient {
    private final UserManagementRepository userDetailsRepository;
    private final UserDetailsMapper userDetailsMapper = UserDetailsMapper.INSTANCE;

    @Autowired
    public UserManagementClientImpl(UserManagementRepository userDetailsRepository){
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public UserDetailsOutputDTO saveUserDetails(UserDetailsInputDTO inputDTO) {
        if(userDetailsRepository.findByUsername(inputDTO.getUsername()) != null){
            throw new CustomException("Username already exists!!!");
        }
        if(userDetailsRepository.findByEmailId(inputDTO.getEmailId()) != null){
            throw new CustomException("Email already exists!!!");
        }
        UserEntity entity = userDetailsMapper.mapInputToEntity(inputDTO);
        entity.setId(UUID.randomUUID());
        userDetailsRepository.save(entity);
        return userDetailsMapper.mapEntityToOutput(entity);
    }

    @Override
    public UserDetailsOutputDTO fetchUserDetails(UserDetailsInputDTO inputDTO) {
        UserEntity entity = userDetailsRepository.findByUsername(inputDTO.getUsername());
        if(entity == null){
            throw new CustomException("No User Exists!!!");
        }
        return userDetailsMapper.mapEntityToOutput(entity);
    }

    @Override
    public UserDetailsOutputDTO updateUserDetails(UserDetailsInputDTO inputDTO) {
        UserEntity entity = userDetailsRepository.findByUsername(inputDTO.getUsername());
        if(entity == null){
            throw new CustomException("No User Exists!!!");
        }
        userDetailsRepository.updateUserDetailsById(inputDTO.getBio(), inputDTO.getUsername());
        entity.setBio(inputDTO.getBio());
        return userDetailsMapper.mapEntityToOutput(entity);
    }
}
