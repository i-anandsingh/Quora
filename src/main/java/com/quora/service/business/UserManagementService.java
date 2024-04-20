package com.quora.service.business;

import com.quora.repository.client.impl.UserManagementClientImpl;
import com.quora.service.models.request.UserDetailsInputDTO;
import com.quora.service.models.response.UserDetailsOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagementService {
    private final UserManagementClientImpl userDetailsClientImpl;

    @Autowired
    public UserManagementService(UserManagementClientImpl userDetailsClientImpl){
        this.userDetailsClientImpl = userDetailsClientImpl;
    }

    public UserDetailsOutputDTO createUserDetails(UserDetailsInputDTO inputDTO) {
        return userDetailsClientImpl.saveUserDetails(inputDTO);
    }

    public UserDetailsOutputDTO fetchUserDetails(UserDetailsInputDTO inputDTO){
        return userDetailsClientImpl.fetchUserDetails(inputDTO);
    }

    public UserDetailsOutputDTO updateUserDetails(UserDetailsInputDTO inputDTO){
        return userDetailsClientImpl.updateUserDetails(inputDTO);
    }
}
