package com.quora.repository.client;

import com.quora.service.models.request.CommentInputDTO;
import com.quora.service.models.request.CommentOnCommentInputDTO;
import com.quora.service.models.response.CommentOnCommentOutputDTO;
import com.quora.service.models.response.CommentOutputDTO;
import org.springframework.stereotype.Component;

@Component
public interface CommentManagementClient {
    CommentOutputDTO commentOnAnswer(CommentInputDTO inputDTO);
    CommentOnCommentOutputDTO commentOnComment(CommentOnCommentInputDTO inputDTO);
}
