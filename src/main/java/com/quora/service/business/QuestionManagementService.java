package com.quora.service.business;

import com.quora.entity.QuestionEntity;
import com.quora.exceptionHandler.CustomException;
import com.quora.mapper.QuestionManagementMapper;
import com.quora.repository.client.QuestionManagementClient;
import com.quora.service.models.request.QuestionInputDTO;
import com.quora.service.models.response.QuestionOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuestionManagementService {

    private final QuestionManagementClient questionManagementClient;
    private final QuestionManagementMapper questionManagementMapper = QuestionManagementMapper.INSTANCE;

    @Autowired
    public QuestionManagementService(QuestionManagementClient questionManagementClient) {
        this.questionManagementClient = questionManagementClient;
    }

    public QuestionOutputDTO postQuestion(QuestionInputDTO inputDTO){
        return questionManagementClient.postQuestion(inputDTO);
    }

    public List<QuestionOutputDTO> searchQuestion(QuestionInputDTO inputDTO){
        List<QuestionEntity> entityList = questionManagementClient.searchQuestion(inputDTO);
        return filterQuestions(entityList, inputDTO);
    }

    private List<QuestionOutputDTO> filterQuestions(List<QuestionEntity> entityList, QuestionInputDTO inputDTO) {
        List<QuestionOutputDTO> outputDTOList = new ArrayList<>();
        if(inputDTO.getText() != null) {
            List<QuestionOutputDTO> outputDTOText = filterBasedOnText(entityList, inputDTO.getText());
            outputDTOList.addAll(outputDTOText);
        } else if(inputDTO.getTopicTags() != null) {
            List<QuestionOutputDTO> outputDTOTag = filterBasedOnTags(entityList, inputDTO.getTopicTags());
            outputDTOList.addAll(outputDTOTag);
        } else {
            return questionManagementMapper.mapEntityToOutputList(entityList);
        }
        Set<QuestionOutputDTO> uniqueOutputDTOs = new HashSet<>(outputDTOList);
        outputDTOList = new ArrayList<>(uniqueOutputDTOs);

        return outputDTOList;
    }

    private List<QuestionOutputDTO> filterBasedOnTags(List<QuestionEntity> entityList, List<String> topicTag) {
        List<QuestionOutputDTO> outputDTOList = new ArrayList<>();
        for(String bodyTag : topicTag) {
            for (QuestionEntity entity : entityList) {
                for (String innerTags : entity.getTopicTags()) {
                    if (bodyTag.equals(innerTags)) {
                        QuestionOutputDTO outputDTO = questionManagementMapper.mapEntityToOutput(entity);
                        outputDTOList.add(outputDTO);
                    }
                }
            }
        }
        if (outputDTOList.size() != 0) {
        } else {
            throw new CustomException("No question base on tags provided exists!!!");
        }
        return outputDTOList;
    }

    private List<QuestionOutputDTO> filterBasedOnText(List<QuestionEntity> entityList, String text) {
        List<QuestionOutputDTO> outputDTOList = new ArrayList<>();
            for(QuestionEntity questionEntity : entityList){
                QuestionOutputDTO outputDTO;
                if(text.equals(questionEntity.getTitle())){
                    outputDTO = questionManagementMapper.mapEntityToOutput(questionEntity);
                    outputDTOList.add(outputDTO);
                }
            }
            if (outputDTOList.size() != 0) {
            } else {
                throw new CustomException("No question base on text provided exists!!!");
            }
        return outputDTOList;
    }
}
