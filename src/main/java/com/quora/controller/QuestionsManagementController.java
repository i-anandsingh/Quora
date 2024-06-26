package com.quora.controller;

import com.quora.apimodels.request.QuestionRequestDTO;
import com.quora.mapper.QuestionManagementMapper;
import com.quora.service.business.QuestionManagementService;
import com.quora.service.models.request.QuestionInputDTO;
import com.quora.service.models.response.QuestionOutputDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class QuestionsManagementController {

    private final QuestionManagementService questionManagementService;
    private final QuestionManagementMapper questionManagementMapper = QuestionManagementMapper.INSTANCE;

    public QuestionsManagementController(QuestionManagementService questionManagementService){
        this.questionManagementService = questionManagementService;
    }

    @PostMapping("/questions")
    private ResponseEntity<QuestionOutputDTO> postQuestion(
            @RequestBody QuestionRequestDTO requestDTO
    ){
        QuestionInputDTO inputDTO = questionManagementMapper.mapRequestToInput(requestDTO);
        QuestionOutputDTO outputDTO = questionManagementService.postQuestion(inputDTO);
        return new ResponseEntity<>(outputDTO, HttpStatus.CREATED);
    }

//    @GetMapping("/questions/search")
//    private ResponseEntity<List<QuestionOutputDTO>> searchQuestion(
//            @RequestParam(name = "title", required = false) String title,
//            @RequestParam(name = "tag", required = false) List<String> tags
//    ){
//        QuestionInputDTO inputDTO = new QuestionInputDTO();
//        inputDTO.setTitle(title);
//        inputDTO.setTopicTags(tags);
//        List<QuestionOutputDTO> outputDTO = questionManagementService.searchQuestion(inputDTO);
//        return new ResponseEntity<>(outputDTO, HttpStatus.OK);
//    }
}
