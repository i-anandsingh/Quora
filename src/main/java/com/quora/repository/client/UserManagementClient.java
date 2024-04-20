package com.quora.repository.client;

import com.quora.service.models.request.UserDetailsInputDTO;
import com.quora.service.models.response.UserDetailsOutputDTO;
import org.springframework.stereotype.Component;

@Component
public interface UserManagementClient {
    UserDetailsOutputDTO saveUserDetails(UserDetailsInputDTO inputDTO);
    UserDetailsOutputDTO fetchUserDetails(UserDetailsInputDTO inputDTO);
    UserDetailsOutputDTO updateUserDetails(UserDetailsInputDTO inputDTO);
}
