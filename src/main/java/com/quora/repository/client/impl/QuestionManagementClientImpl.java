package com.quora.repository.client.impl;

import com.quora.entity.QuestionEntity;
import com.quora.entity.UserEntity;
import com.quora.mapper.QuestionManagementMapper;
import com.quora.repository.QuestionManagementRepository;
import com.quora.repository.UserManagementRepository;
import com.quora.repository.client.QuestionManagementClient;
import com.quora.service.models.request.QuestionInputDTO;
import com.quora.service.models.response.QuestionOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class QuestionManagementClientImpl implements QuestionManagementClient {
    private UUID uuid;
    private final QuestionManagementRepository questionManagementRepository;
    private final UserManagementRepository userManagementRepository;
    private QuestionManagementMapper questionManagementMapper = QuestionManagementMapper.INSTANCE;

    @Autowired
    public QuestionManagementClientImpl (
            QuestionManagementRepository questionManagementRepository,
            UserManagementRepository userManagementRepository
    ){
        this.userManagementRepository = userManagementRepository;
        this.questionManagementRepository = questionManagementRepository;
    }

    @Override
    public QuestionOutputDTO postQuestion(QuestionInputDTO inputDTO) {
        UserEntity user = userManagementRepository.findById(inputDTO.getUser_Id());
        if (user == null) {
            // TODO -> Return some Exception
            return null;
        }
        QuestionEntity entity = questionManagementMapper.mapInputToEntity(inputDTO);
        entity.setQuestion_Id(UUID.randomUUID());
        entity.setUser(user);
        questionManagementRepository.save(entity);
        return questionManagementMapper.mapEntityToOutput(entity);
    }

    @Override
    public List<QuestionEntity> searchQuestion(QuestionInputDTO inputDTO) {
        QuestionEntity entity = new QuestionEntity();
        entity.setTitle(inputDTO.getText());
        entity.setTopicTags(inputDTO.getTopicTags());
        return questionManagementRepository.findAll();
    }

    //implement a method to search all the questions by a user
}
