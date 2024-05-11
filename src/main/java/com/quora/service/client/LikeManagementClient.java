package com.quora.service.client;

import com.quora.service.models.request.LikeInputDTO;
import com.quora.service.models.response.LikeOutputDTO;
import org.springframework.stereotype.Component;

@Component
public interface LikeManagementClient {
    public LikeOutputDTO doLike(LikeInputDTO inputDTO);
}
