package com.quora.service.business;

import com.quora.service.client.CommentManagementClient;
import com.quora.service.models.request.CommentInputDTO;
import com.quora.service.models.request.CommentOnCommentInputDTO;
import com.quora.service.models.response.CommentOnCommentOutputDTO;
import com.quora.service.models.response.CommentOutputDTO;
import org.springframework.stereotype.Service;

@Service
public class CommentManagementService {
    private final CommentManagementClient commentManagementClient;


    private CommentManagementService(CommentManagementClient commentManagementClient){
        this.commentManagementClient = commentManagementClient;
    }
    public CommentOutputDTO doComment(CommentInputDTO inputDTO){
        return commentManagementClient.commentOnAnswer(inputDTO);
    }

    public CommentOnCommentOutputDTO doCommOnComment(CommentOnCommentInputDTO inputDTO){
        return commentManagementClient.commentOnComment(inputDTO);
    }
}
