package com.quora.service.business;

import com.quora.repository.client.UserManagementClient;
import com.quora.service.models.request.UserDetailsInputDTO;
import com.quora.service.models.response.UserDetailsOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagementService {
    private final UserManagementClient userDetailsClient;

    @Autowired
    public UserManagementService(UserManagementClient userDetailsClient){
        this.userDetailsClient = userDetailsClient;
    }

    public UserDetailsOutputDTO createUserDetails(UserDetailsInputDTO inputDTO) {
        return userDetailsClient.saveUserDetails(inputDTO);
    }

    public UserDetailsOutputDTO fetchUserDetails(UserDetailsInputDTO inputDTO){
        return userDetailsClient.fetchUserDetails(inputDTO);
    }

    public UserDetailsOutputDTO updateUserDetails(UserDetailsInputDTO inputDTO){
        return userDetailsClient.updateUserDetails(inputDTO);
    }
}
