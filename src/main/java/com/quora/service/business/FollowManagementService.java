package com.quora.service.business;

import com.quora.repository.client.FollowManagementClient;
import com.quora.service.models.request.FollowInputDTO;
import com.quora.service.models.response.FollowOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowManagementService {
    private FollowManagementClient followManagementClient;

    @Autowired
    private FollowManagementService(
            FollowManagementClient followManagementClient
    ) {
        this.followManagementClient = followManagementClient;
    }
    public FollowOutputDTO doFollow(FollowInputDTO inputDTO){
        return followManagementClient.follow(inputDTO);
    }
}
