package com.quora.service.business;

import com.quora.entity.QuestionEntity;
import com.quora.mapper.QuestionManagementMapper;
import com.quora.repository.client.impl.QuestionManagementClientImpl;
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

    private final QuestionManagementClientImpl questionManagementClientImpl;
    private final QuestionManagementMapper questionManagementMapper = QuestionManagementMapper.INSTANCE;

    @Autowired
    public QuestionManagementService(QuestionManagementClientImpl questionManagementClientImpl) {
        this.questionManagementClientImpl = questionManagementClientImpl;
    }

    public QuestionOutputDTO postQuestion(QuestionInputDTO inputDTO){
        return questionManagementClientImpl.postQuestion(inputDTO);
    }

    public List<QuestionOutputDTO> searchQuestion(QuestionInputDTO inputDTO){
        List<QuestionEntity> entityList = questionManagementClientImpl.searchQuestion(inputDTO);
        return filterQuestions(entityList, inputDTO);
    }

    private List<QuestionOutputDTO> filterQuestions(List<QuestionEntity> entityList, QuestionInputDTO inputDTO) {
        List<QuestionOutputDTO> outputDTOList = new ArrayList<>();
        if(inputDTO.getText() != null) {
            List<QuestionOutputDTO> outputDTOText = filterBasedOnText(entityList, inputDTO.getText());
            outputDTOList.addAll(outputDTOText);
        } else if(inputDTO.getTag() != null) {
            List<QuestionOutputDTO> outputDTOTag = filterBasedOnTags(entityList, inputDTO.getTag());
            outputDTOList.addAll(outputDTOTag);
        } else {
            return questionManagementMapper.mapEntityToOutputList(entityList);
        }

        if(outputDTOList.size() == 0){
            return null;
            // TODO later -> throw new BusinessException(Response.Status.NOT_FOUND,"No Question Found");
        }

        Set<QuestionOutputDTO> uniqueOutputDTOs = new HashSet<>(outputDTOList);
        outputDTOList = new ArrayList<>(uniqueOutputDTOs);

        return outputDTOList;
    }

    private List<QuestionOutputDTO> filterBasedOnTags(List<QuestionEntity> entityList, String topicTag) {
        List<QuestionOutputDTO> outputDTOList = new ArrayList<>();
        for (QuestionEntity entity : entityList) {
            for(String innerTags : entity.getTopicTags()){
                if(topicTag.equals(innerTags)){
                    QuestionOutputDTO outputDTO;
                    outputDTO = questionManagementMapper.mapEntityToOutput(entity);
                    outputDTOList.add(outputDTO);
                }
            }
        }
        if (outputDTOList.size() != 0) {
        } else {
            // TODO later -> throw new BusinessException(Response.Status.NOT_FOUND,"No Question Found");
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
                // TODO later -> throw new BusinessException(Response.Status.NOT_FOUND,"No Question Found");
            }
        return outputDTOList;
    }
}
