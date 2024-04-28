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
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/questions/search")
    private ResponseEntity<List<QuestionResponseDTO>> searchQuestion(
            @RequestParam(name = "text", required = false) String text,
            @RequestParam(name = "tag", required = false) List<String> tags
    ){
        QuestionInputDTO inputDTO = new QuestionInputDTO();
        inputDTO.setText(text);
        inputDTO.setTopicTags(tags);
        List<QuestionOutputDTO> outputDTO = questionManagementService.searchQuestion(inputDTO);
        List<QuestionResponseDTO> responseDTO = questionManagementMapper.mapOutputToResponseList(outputDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
