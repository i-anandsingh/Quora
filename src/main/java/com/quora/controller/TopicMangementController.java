package com.quora.controller;

import com.quora.apimodels.request.TopicRequestDTO;
import com.quora.apimodels.response.FetchAllTopicsResponseDTO;
import com.quora.apimodels.response.TopicResponseDTO;
import com.quora.mapper.TopicManagementMapper;
import com.quora.service.business.TopicManagementService;
import com.quora.service.models.request.TopicInputDTO;
import com.quora.service.models.response.TopicOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class TopicMangementController {
    private final TopicManagementMapper topicManagementMapper = TopicManagementMapper.INSTANCE;
    private final TopicManagementService topicManagementService;

    @Autowired
    private TopicMangementController (
            TopicManagementService topicManagementService
    ) {
        this.topicManagementService = topicManagementService;
    }

    @PostMapping("/topics")
    private ResponseEntity<TopicResponseDTO> topicManagement(
            @RequestBody TopicRequestDTO requestDTO
    ) {
        TopicInputDTO inputDTO = topicManagementMapper.mapRequestToInput(requestDTO);
        TopicOutputDTO outputDTO = topicManagementService.saveTopics(inputDTO);
        TopicResponseDTO responseDTO = topicManagementMapper.mapOutputToResponse(outputDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("/topics")
    private ResponseEntity<FetchAllTopicsResponseDTO> fetchAllTopics() {
        return new ResponseEntity<>(topicManagementService.fetchAllTopics(), HttpStatus.OK);

    }
}
