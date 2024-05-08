package com.quora.repository.client.impl;

import com.quora.entity.AnswerEntity;
import com.quora.entity.CommentEntity;
import com.quora.entity.UserEntity;
import com.quora.exceptionHandler.CustomException;
import com.quora.mapper.CommentManagementMapper;
import com.quora.mapper.CommentOnCommentMapper;
import com.quora.repository.AnswerManagementRepository;
import com.quora.repository.CommentManagementRepository;
import com.quora.repository.UserManagementRepository;
import com.quora.repository.client.CommentManagementClient;
import com.quora.service.models.request.CommentInputDTO;
import com.quora.service.models.request.CommentOnCommentInputDTO;
import com.quora.service.models.response.CommentOnCommentOutputDTO;
import com.quora.service.models.response.CommentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CommentManagementClientImpl implements CommentManagementClient {
    private CommentManagementMapper commentManagementMapper = CommentManagementMapper.INSTANCE;
    private CommentOnCommentMapper commentOnCommentMapper = CommentOnCommentMapper.INSTANCE;
    private final CommentManagementRepository commentManagementRepository;
    private final UserManagementRepository userManagementRepository;
    private final AnswerManagementRepository answerManagementRepository;

    @Autowired
    private CommentManagementClientImpl(
            CommentManagementRepository commentManagementRepository,
            UserManagementRepository userManagementRepository,
            AnswerManagementRepository answerManagementRepository
    ){
        this.commentManagementRepository = commentManagementRepository;
        this.userManagementRepository = userManagementRepository;
        this.answerManagementRepository = answerManagementRepository;
    }
    @Override
    public CommentOutputDTO commentOnAnswer(CommentInputDTO inputDTO) {
        UserEntity user = userManagementRepository.findByUserId(inputDTO.getUserId());
        AnswerEntity answer = answerManagementRepository.findByAnswerId(inputDTO.getAnswerId());
        if(user == null || answer == null){
            throw new CustomException("UserId or AnswerId Not Found");
        }
        CommentEntity commentEntity = commentManagementMapper.mapInputToEntity(inputDTO);
        commentEntity.setCommentId(UUID.randomUUID());
        commentEntity.setUser(user);
        commentEntity.setAnswer(answer);
        commentManagementRepository.save(commentEntity);
        return commentManagementMapper.mapEntityToOutput(commentEntity);
    }

    @Override
    public CommentOnCommentOutputDTO commentOnComment(CommentOnCommentInputDTO inputDTO) {
        // TODO -> implement at last
//        CommentEntity parentComment = commentManagementRepository.findByCommentId(inputDTO.getCommentId());
//        if(parentComment == null){
//            // TODO -> raise an exception
//            return null;
//        }
//        UserEntity userEntity = userManagementRepository.findByUserId(inputDTO.getUserId());
//        if(userEntity == null){
//            // TODO -> raise an exception
//            return null;
//        }
//        CommentEntity commentOnCommentEntity = new CommentEntity();
//        commentOnCommentEntity.setCommentId(UUID.randomUUID());
//        commentOnCommentEntity.setUser(userEntity);
//        commentManagementRepository.save(commentOnCommentEntity);
//        return commentOnCommentMapper.mapEntityToOutput(commentOnCommentEntity);
        return null;
    }

}
