package com.quora.repository.client.impl;

import com.quora.apimodels.response.FetchAllTopicsResponseDTO;
import com.quora.entity.TopicEntity;
import com.quora.mapper.TopicManagementMapper;
import com.quora.repository.TopicManagementRepository;
import com.quora.repository.client.TopicManagementClient;
import com.quora.service.models.request.TopicInputDTO;
import com.quora.service.models.response.TopicOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class TopicManagementClientImpl implements TopicManagementClient {

    private final TopicManagementRepository topicManagementRepository;
    private final TopicManagementMapper topicManagementMapper = TopicManagementMapper.INSTANCE;

    @Autowired
    private TopicManagementClientImpl (
            TopicManagementRepository topicManagementRepository
    ) {
        this.topicManagementRepository = topicManagementRepository;
    }

    @Override
    public FetchAllTopicsResponseDTO fetchTopics() {
        List<TopicEntity> topicEntityList = topicManagementRepository.findAll();
        List<String> topics = new ArrayList<>();
        for(TopicEntity entity : topicEntityList){
            for(String topic : entity.getTopics()){
                topics.add(topic);
            }
        }
        FetchAllTopicsResponseDTO outputDTO = new FetchAllTopicsResponseDTO();
        outputDTO.setTopics(topics);
        return outputDTO;
    }

    @Override
    public TopicOutputDTO saveTopics(TopicInputDTO inputDTO) {
        TopicEntity entity = new TopicEntity();
        entity.setId(UUID.randomUUID());
        entity.setTopics(inputDTO.getTopics());
        topicManagementRepository.save(entity);

        return topicManagementMapper.mapEntityToOutput(entity);
    }
}
