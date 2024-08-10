package com.quora.service.client;

import com.quora.entity.AnswerEntity;
import com.quora.entity.CommentEntity;
import com.quora.entity.UserEntity;
import com.quora.exceptionHandler.CustomException;
import com.quora.mapper.CommentManagementMapper;
import com.quora.repository.AnswerManagementRepository;
import com.quora.repository.CommentManagementRepository;
import com.quora.repository.UserManagementRepository;
import com.quora.service.models.request.CommentInputDTO;
import com.quora.service.models.request.CommentOnCommentInputDTO;
import com.quora.service.models.response.CommentOnCommentOutputDTO;
import com.quora.service.models.response.CommentOutputDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CommentManagementClient {
    private final CommentManagementMapper commentManagementMapper = CommentManagementMapper.INSTANCE;
    private final CommentManagementRepository commentManagementRepository;
    private final UserManagementRepository userManagementRepository;
    private final AnswerManagementRepository answerManagementRepository;


    private CommentManagementClient(
            CommentManagementRepository commentManagementRepository,
            UserManagementRepository userManagementRepository,
            AnswerManagementRepository answerManagementRepository
    ){
        this.commentManagementRepository = commentManagementRepository;
        this.userManagementRepository = userManagementRepository;
        this.answerManagementRepository = answerManagementRepository;
    }

    public CommentOutputDTO commentOnAnswer(CommentInputDTO inputDTO) {
        UserEntity user = userManagementRepository.findByUsername(inputDTO.getUsername());
        if(user == null) {
            throw new CustomException("User not found");
        }
        AnswerEntity answer = answerManagementRepository.findAnswerEntitiesById(inputDTO.getAnswerId());
        if(answer == null) {
            throw new CustomException("Answer not found");
        }
        CommentEntity commentEntity = commentManagementMapper.mapInputToEntity(inputDTO);
        commentEntity.setId(UUID.randomUUID());
        commentEntity.setUser(user);
        commentEntity.setAnswer(answer);
        commentManagementRepository.save(commentEntity);
        CommentOutputDTO outputDTO = commentManagementMapper.mapEntityToOutput(commentEntity);
        outputDTO.setRemarks("Comment Successful.");
        return outputDTO;
    }


    public CommentOnCommentOutputDTO commentOnComment(CommentOnCommentInputDTO inputDTO) {
        UserEntity user = userManagementRepository.findByUsername(inputDTO.getUsername());
        if (user == null) {
            throw new CustomException("User does not exist.");
        }

        CommentEntity parentComment = null;
        if (inputDTO.getParentCommentId() != null) {
            parentComment = commentManagementRepository.findCommentEntityById(inputDTO.getParentCommentId())
                    .orElseThrow(() -> new CustomException("Parent comment does not exist."));
        }

        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setId(UUID.randomUUID());
        commentEntity.setUser(user);
        commentEntity.setComment(inputDTO.getComment());
        commentEntity.setParentComment(parentComment);

        commentManagementRepository.save(commentEntity);

        CommentOnCommentOutputDTO outputDTO = new CommentOnCommentOutputDTO();
        outputDTO.setCommentId(commentEntity.getId());
        outputDTO.setComment(commentEntity.getComment());
        if (parentComment != null) {
            outputDTO.setParentCommentId(parentComment.getId());
        }
        outputDTO.setRemarks("Comment added successfully!");

        return outputDTO;
    }

}
