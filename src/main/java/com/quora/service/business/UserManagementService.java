package com.quora.service.business;

import com.quora.service.client.UserManagementClient;
import com.quora.service.models.request.UserDetailsInputDTO;
import com.quora.service.models.response.UserDetailsOutputDTO;
import org.springframework.stereotype.Service;

@Service
public class UserManagementService {
    private final UserManagementClient userDetailsClient;


    private UserManagementService(UserManagementClient userDetailsClient){
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
