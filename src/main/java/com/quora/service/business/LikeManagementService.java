package com.quora.service.business;

import com.quora.service.client.LikeManagementClient;
import com.quora.service.models.request.LikeInputDTO;
import com.quora.service.models.response.LikeOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeManagementService {

    private final LikeManagementClient likeManagementClient;

    @Autowired
    private LikeManagementService(
            LikeManagementClient likeManagementClient
    ) {
        this.likeManagementClient = likeManagementClient;
    }
    public LikeOutputDTO doLike(LikeInputDTO inputDTO){
        return likeManagementClient.doLike(inputDTO);
    }
}
