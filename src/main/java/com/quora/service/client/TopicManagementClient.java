package com.quora.service.client;

import com.quora.apimodels.response.FetchAllTopicsResponseDTO;
import com.quora.service.models.request.TopicInputDTO;
import com.quora.service.models.response.TopicOutputDTO;
import org.springframework.stereotype.Component;

@Component
public interface TopicManagementClient {
    FetchAllTopicsResponseDTO fetchTopics();
    TopicOutputDTO saveTopics(TopicInputDTO inputDTO);
}
