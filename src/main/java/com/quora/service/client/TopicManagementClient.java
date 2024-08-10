package com.quora.service.client;

import com.quora.apimodels.response.FetchAllTopicsResponseDTO;
import com.quora.entity.TopicEntity;
import com.quora.repository.TopicManagementRepository;
import com.quora.service.models.request.TopicInputDTO;
import com.quora.service.models.response.TopicOutputDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class TopicManagementClient {

    private final TopicManagementRepository topicManagementRepository;

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
        return FetchAllTopicsResponseDTO.builder().topics(topics).build();
    }


    public List<TopicOutputDTO> saveTopics(TopicInputDTO inputDTO) {
        // Process each topic in the input list
        List<TopicEntity> topicEntities = inputDTO.getTopics().stream()
                .map(topic -> {
                    // Check if the topic already exists in the repository
                    TopicEntity existingTopic = topicManagementRepository.findByTopics(topic);
                    if (existingTopic == null) {
                        // If not, create and save a new TopicEntity with a unique UUID
                        TopicEntity newTopic = new TopicEntity();
                        newTopic.setId(UUID.randomUUID());
                        newTopic.setTopics(topic);
                        return topicManagementRepository.save(newTopic);
                    }
                    return existingTopic;
                })
                .toList();

        // Convert the saved entities to TopicOutputDTO
        return topicEntities.stream()
                .map(entity -> new TopicOutputDTO(entity.getTopics()))
                .collect(Collectors.toList());
    }
}
