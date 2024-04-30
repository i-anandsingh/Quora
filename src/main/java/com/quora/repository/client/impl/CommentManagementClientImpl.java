package com.quora.repository.client.impl;

import com.quora.entity.AnswerEntity;
import com.quora.entity.CommentEntity;
import com.quora.entity.UserEntity;
import com.quora.mapper.CommentManagementMapper;
import com.quora.repository.AnswerManagementRepository;
import com.quora.repository.CommentManagementRepository;
import com.quora.repository.UserManagementRepository;
import com.quora.repository.client.CommentManagementClient;
import com.quora.service.models.request.CommentInputDTO;
import com.quora.service.models.response.CommentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CommentManagementClientImpl implements CommentManagementClient {
    private CommentManagementMapper commentManagementMapper = CommentManagementMapper.INSTANCE;
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
            // TODO -> throw an exception
            System.out.println("UserId or AnswerId Not Found");
            return null;
        }
        CommentEntity commentEntity = commentManagementMapper.mapInputToEntity(inputDTO);
        commentEntity.setCommentId(UUID.randomUUID());
        commentEntity.setUser(user);
        commentEntity.setAnswer(answer);
        commentManagementRepository.save(commentEntity);
        return commentManagementMapper.mapEntityToOutput(commentEntity);
    }
}
