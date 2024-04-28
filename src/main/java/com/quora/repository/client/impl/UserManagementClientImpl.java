package com.quora.repository.client.impl;

import com.quora.entity.UserEntity;
import com.quora.mapper.UserDetailsMapper;
import com.quora.repository.UserManagementRepository;
import com.quora.repository.client.UserManagementClient;
import com.quora.service.models.request.UserDetailsInputDTO;
import com.quora.service.models.response.UserDetailsOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserManagementClientImpl implements UserManagementClient {
    private UUID uuid;
    private final UserManagementRepository userDetailsRepository;
    private static final UserDetailsMapper userDetailsMapper = UserDetailsMapper.INSTANCE;

    @Autowired
    public UserManagementClientImpl(UserManagementRepository userDetailsRepository){
        this.userDetailsRepository = userDetailsRepository;
    }
    @Override
    public UserDetailsOutputDTO saveUserDetails(UserDetailsInputDTO inputDTO) {
        UserEntity entity = userDetailsMapper.mapInputToEntity(inputDTO);
        entity.setId(uuid.randomUUID());
        userDetailsRepository.save(entity);
        return userDetailsMapper.mapEntitytoOutput(entity);
    }

    @Override
    public UserDetailsOutputDTO fetchUserDetails(UserDetailsInputDTO inputDTO) {
        UserEntity entity = userDetailsRepository.findById(inputDTO.getUserId());
        return userDetailsMapper.mapEntitytoOutput(entity);
    }

    @Override
    public UserDetailsOutputDTO updateUserDetails(UserDetailsInputDTO inputDTO) {
        userDetailsRepository.updateUserDetailsById(inputDTO.getBio(), inputDTO.getUserId());
        UserEntity entity = userDetailsRepository.findById(inputDTO.getUserId());
        return userDetailsMapper.mapEntitytoOutput(entity);
    }
}
