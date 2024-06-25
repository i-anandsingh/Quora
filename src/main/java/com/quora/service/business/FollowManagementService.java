package com.quora.service.business;

import com.quora.service.client.FollowManagementClient;
import com.quora.service.models.request.FollowInputDTO;
import com.quora.service.models.response.FollowOutputDTO;
import org.springframework.stereotype.Service;

@Service
public class FollowManagementService {
    private FollowManagementClient followManagementClient;


    private FollowManagementService( FollowManagementClient followManagementClient) {
        this.followManagementClient = followManagementClient;
    }

    public FollowOutputDTO doFollow(FollowInputDTO inputDTO){
        return followManagementClient.follow(inputDTO);
    }
}
