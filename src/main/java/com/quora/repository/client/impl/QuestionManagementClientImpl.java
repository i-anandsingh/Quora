package com.quora.repository.client.impl;

import com.quora.entity.QuestionEntity;
import com.quora.mapper.QuestionManagementMapper;
import com.quora.repository.QuestionManagementRepository;
import com.quora.repository.client.QuestionManagementClient;
import com.quora.service.models.request.QuestionInputDTO;
import com.quora.service.models.response.QuestionOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionManagementClientImpl implements QuestionManagementClient {
    private final QuestionManagementRepository questionManagementRepository;
    private QuestionManagementMapper questionManagementMapper = QuestionManagementMapper.INSTANCE;

    @Autowired
    public QuestionManagementClientImpl (QuestionManagementRepository questionManagementRepository){
        this.questionManagementRepository = questionManagementRepository;
    }

    @Override
    public QuestionOutputDTO postQuestion(QuestionInputDTO inputDTO) {
        QuestionEntity entity = questionManagementMapper.mapInputToEntity(inputDTO);
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
}
