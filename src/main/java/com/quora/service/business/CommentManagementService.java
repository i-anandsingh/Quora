package com.quora.service.business;

import com.quora.repository.client.CommentManagementClient;
import com.quora.service.models.request.CommentInputDTO;
import com.quora.service.models.response.CommentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentManagementService {
    private final CommentManagementClient commentManagementClient;

    @Autowired
    private CommentManagementService(CommentManagementClient commentManagementClient){
        this.commentManagementClient = commentManagementClient;
    }
    public CommentOutputDTO commentOnAnswer(CommentInputDTO inputDTO){
        return commentManagementClient.commentOnAnswer(inputDTO);
    }
}
