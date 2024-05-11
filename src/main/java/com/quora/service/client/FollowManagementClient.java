package com.quora.service.client;

import com.quora.service.models.request.FollowInputDTO;
import com.quora.service.models.response.FollowOutputDTO;
import org.springframework.stereotype.Component;

@Component
public interface FollowManagementClient {
    FollowOutputDTO follow(FollowInputDTO inputDTO);
}
