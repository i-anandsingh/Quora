package com.quora.service.client;

import com.quora.apimodels.response.FetchAllTopicsResponseDTO;
import com.quora.entity.TopicEntity;
import com.quora.mapper.TopicManagementMapper;
import com.quora.repository.TopicManagementRepository;
import com.quora.service.models.request.TopicInputDTO;
import com.quora.service.models.response.TopicOutputDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class TopicManagementClient {

    private final TopicManagementRepository topicManagementRepository;
    private final TopicManagementMapper topicManagementMapper = TopicManagementMapper.INSTANCE;


    private TopicManagementClient(
            TopicManagementRepository topicManagementRepository
    ) {
        this.topicManagementRepository = topicManagementRepository;
    }


    public FetchAllTopicsResponseDTO fetchTopics() {
        List<TopicEntity> topicEntityList = topicManagementRepository.findAll();
        List<String> topics = new ArrayList<>();
        for(TopicEntity entity : topicEntityList){
            topics.add(entity.getTopics());
        }
        FetchAllTopicsResponseDTO outputDTO = new FetchAllTopicsResponseDTO();
        outputDTO.setTopics(topics);
        return outputDTO;
    }


    public TopicOutputDTO saveTopics(TopicInputDTO inputDTO) {
        TopicEntity entity = new TopicEntity();
        entity.setId(UUID.randomUUID());
        entity.setTopics(inputDTO.getTopics());
        topicManagementRepository.save(entity);
        return topicManagementMapper.mapEntityToOutput(entity);
    }
}
