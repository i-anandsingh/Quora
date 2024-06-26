package com.quora.service.business;

import com.quora.apimodels.response.FetchAllTopicsResponseDTO;
import com.quora.mapper.TopicManagementMapper;
import com.quora.service.client.TopicManagementClient;
import com.quora.service.models.request.TopicInputDTO;
import com.quora.service.models.response.TopicOutputDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicManagementService {
    private final TopicManagementMapper topicManagementMapper = TopicManagementMapper.INSTANCE;
    private final TopicManagementClient topicManagementClient;


    private TopicManagementService(
            TopicManagementClient topicManagementClient
    ) {
        this.topicManagementClient = topicManagementClient;
    }

    public List<TopicOutputDTO> saveTopics(TopicInputDTO inputDTO){
        return topicManagementClient.saveTopics(inputDTO);
    }

    public FetchAllTopicsResponseDTO fetchAllTopics() {
        return topicManagementClient.fetchTopics();
    }
}
