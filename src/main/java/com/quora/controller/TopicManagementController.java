package com.quora.controller;

import com.quora.apimodels.request.TopicRequestDTO;
import com.quora.apimodels.response.FetchAllTopicsResponseDTO;
import com.quora.mapper.TopicManagementMapper;
import com.quora.service.business.TopicManagementService;
import com.quora.service.models.request.TopicInputDTO;
import com.quora.service.models.response.TopicOutputDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class TopicManagementController {
    private final TopicManagementMapper topicManagementMapper = TopicManagementMapper.INSTANCE;
    private final TopicManagementService topicManagementService;


    private TopicManagementController (
            TopicManagementService topicManagementService
    ) {
        this.topicManagementService = topicManagementService;
    }

    @PostMapping("/topics")
    private ResponseEntity<List<TopicOutputDTO>> topicManagement(
            @RequestBody TopicRequestDTO requestDTO
    ) {
        TopicInputDTO inputDTO = topicManagementMapper.mapRequestToInput(requestDTO);
        List<TopicOutputDTO> outputDTO = topicManagementService.saveTopics(inputDTO);
        return new ResponseEntity<>(outputDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("/topics")
    private ResponseEntity<FetchAllTopicsResponseDTO> fetchAllTopics() {
        return new ResponseEntity<>(topicManagementService.fetchAllTopics(), HttpStatus.OK);
    }
}
