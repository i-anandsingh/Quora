package com.quora.repository.client.impl;

import com.quora.entity.AnswerEntity;
import com.quora.entity.QuestionEntity;
import com.quora.entity.UserEntity;
import com.quora.mapper.AnswerManagementMapper;
import com.quora.repository.AnswerManagementRepository;
import com.quora.repository.QuestionManagementRepository;
import com.quora.repository.UserManagementRepository;
import com.quora.repository.client.AnswerManagementClient;
import com.quora.service.models.request.AnswerInputDTO;
import com.quora.service.models.response.AnswerOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AnswerManagementClientImpl implements AnswerManagementClient {
    private AnswerManagementRepository answerManagementRepository;
    private UserManagementRepository userManagementRepository;
    private QuestionManagementRepository questionManagementRepository;
    private AnswerManagementMapper answerManagementMapper = AnswerManagementMapper.INSTANCE;

    @Autowired
    private AnswerManagementClientImpl(
            AnswerManagementRepository answerManagementRepository,
            UserManagementRepository userManagementRepository,
            QuestionManagementRepository questionManagementRepository
    ){
        this.answerManagementRepository = answerManagementRepository;
        this.userManagementRepository = userManagementRepository;
        this.questionManagementRepository = questionManagementRepository;
    }
    @Override
    public AnswerOutputDTO postAnswer(AnswerInputDTO inputDTO) {
        UserEntity user = userManagementRepository.findByUserId(inputDTO.getUserId());
        QuestionEntity question = questionManagementRepository.findByQuestionId(inputDTO.getQuestionId());
        if (user == null) {
            // TODO -> Return some Exception
            return null;
        }
        AnswerEntity entity = answerManagementMapper.mapInputToEntity(inputDTO);
        entity.setAnswerId(UUID.randomUUID());
        entity.setUser(user);
        entity.setQuestion(question);
        answerManagementRepository.save(entity);
        return answerManagementMapper.mapEntityToOutput(entity);
    }
}
