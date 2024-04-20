package com.quora.controller;

import com.quora.apimodels.request.QuestionRequestDTO;
import com.quora.apimodels.response.QuestionResponseDTO;
import com.quora.mapper.QuestionManagementMapper;
import com.quora.service.business.QuestionManagementService;
import com.quora.service.models.request.QuestionInputDTO;
import com.quora.service.models.response.QuestionOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class QuestionsManagementController {

    private QuestionManagementService questionManagementService;
    private QuestionManagementMapper questionManagementMapper = QuestionManagementMapper.INSTANCE;

    @Autowired
    public QuestionsManagementController(QuestionManagementService questionManagementService){
        this.questionManagementService = questionManagementService;
    }

    @PostMapping("/questions")
    private ResponseEntity<QuestionResponseDTO> postQuestion(@RequestBody QuestionRequestDTO requestDTO){
        QuestionInputDTO inputDTO = questionManagementMapper.mapRequestToInput(requestDTO);
        QuestionOutputDTO outputDTO = questionManagementService.postQuestion(inputDTO);
        QuestionResponseDTO responseDTO = questionManagementMapper.mapOutputToResponse(outputDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
