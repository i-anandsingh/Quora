package com.quora.service.client;

import com.quora.entity.QuestionEntity;
import com.quora.entity.TopicEntity;
import com.quora.entity.UserEntity;
import com.quora.exceptionHandler.CustomException;
import com.quora.mapper.QuestionManagementMapper;
import com.quora.repository.QuestionManagementRepository;
import com.quora.repository.TopicManagementRepository;
import com.quora.repository.UserManagementRepository;
import com.quora.service.models.request.QuestionInputDTO;
import com.quora.service.models.response.QuestionOutputDTO;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class QuestionManagementClient {
    private final QuestionManagementRepository questionManagementRepository;
    private final UserManagementRepository userManagementRepository;
    private final TopicManagementRepository topicManagementRepository;
    private final QuestionManagementMapper questionManagementMapper = QuestionManagementMapper.INSTANCE;


    public QuestionManagementClient(
            QuestionManagementRepository questionManagementRepository,
            UserManagementRepository userManagementRepository,
            TopicManagementRepository topicManagementRepository
    ){
        this.userManagementRepository = userManagementRepository;
        this.questionManagementRepository = questionManagementRepository;
        this.topicManagementRepository = topicManagementRepository;
    }


    public QuestionOutputDTO postQuestion(QuestionInputDTO inputDTO) {
        UserEntity user = userManagementRepository.findByUsername(inputDTO.getUsername());
        if (user == null) {
            throw new CustomException("Please create an account first.");
        }

        List<TopicEntity> topicEntities = inputDTO.getTopicTags().stream()
                .map(topic -> {
                    TopicEntity existingTopic = topicManagementRepository.findByTopics(topic);
                    if (existingTopic == null) {
                        TopicEntity newTopic = new TopicEntity();
                        newTopic.setTopics(topic);
                        newTopic.setId(UUID.randomUUID());
                        return topicManagementRepository.save(newTopic);
                    }
                    return existingTopic;
                })
                .collect(Collectors.toList());

        QuestionEntity entity = questionManagementMapper.mapInputToEntity(inputDTO);
        entity.setId(UUID.randomUUID());
        entity.setUser(user);
        entity.setTopicTags(topicEntities);
        questionManagementRepository.save(entity);
        return questionManagementMapper.mapEntityToOutput(entity);
    }


    public List<QuestionOutputDTO> searchQuestion(QuestionInputDTO inputDTO) {
        List<QuestionEntity> allQuestions = questionManagementRepository.findAll();
        return filterQuestions(allQuestions, inputDTO);
    }

    private List<QuestionOutputDTO> filterQuestions(List<QuestionEntity> entityList, QuestionInputDTO inputDTO) {
        if(inputDTO.getTitle() == null && inputDTO.getTopicTags() == null){
            return questionManagementMapper.mapEntityListToOutputList(entityList);
        }
        Set<QuestionOutputDTO>  outputDTOText= new HashSet<>();
        if(inputDTO.getTitle() != null) {
            outputDTOText = filterBasedOnTitle(entityList, inputDTO.getTitle());
        }
        Set<QuestionOutputDTO> outputDTOTag = new HashSet<>();
        if(inputDTO.getTopicTags() != null) {
            outputDTOTag = filterBasedOnTags(entityList, inputDTO.getTopicTags());
        }
        Set<QuestionOutputDTO> uniqueQuestions = new HashSet<>();
        uniqueQuestions.addAll(outputDTOText);
        uniqueQuestions.addAll(outputDTOTag);
        return new ArrayList<>(uniqueQuestions);
    }

    private Set<QuestionOutputDTO> filterBasedOnTags(List<QuestionEntity> entityList, List<String> topicTags) {
        Set<QuestionOutputDTO> outputDTOList = new HashSet<>();
        for(String topic : topicTags){
            for(QuestionEntity questionEntity : entityList) {
                List<String> questionTopics = questionEntity.getTopicTags().stream()
                        .map(TopicEntity::getTopics)
                        .toList();
                if(questionTopics.contains(topic)) {
                    QuestionOutputDTO outputDTO = questionManagementMapper.mapEntityToOutput(questionEntity);
                    outputDTOList.add(outputDTO);
                }
            }
        }
        if(outputDTOList.isEmpty()){
            throw new CustomException("No matching topic tags were found.");
        }
        return outputDTOList;
    }

    private Set<QuestionOutputDTO> filterBasedOnTitle(List<QuestionEntity> entityList, String title) {
        Set<QuestionOutputDTO> outputDTOList = new HashSet<>();
        for(QuestionEntity questionEntity : entityList){
            if(title.equals(questionEntity.getTitle())){
                QuestionOutputDTO outputDTO = questionManagementMapper.mapEntityToOutput(questionEntity);
                outputDTOList.add(outputDTO);
            }
        }
        if(outputDTOList.isEmpty()) {
            throw new CustomException("No question based on text exists!!!");
        }
        return outputDTOList;
    }
}
