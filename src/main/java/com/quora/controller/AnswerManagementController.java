package com.quora.controller;

import com.quora.apimodels.request.AnswerRequestDTO;
import com.quora.apimodels.request.ModifyAnswerRequestDTO;
import com.quora.apimodels.response.AnswerResponseDTO;
import com.quora.apimodels.response.ModifyAnswerResponseDTO;
import com.quora.mapper.AnswerManagementMapper;
import com.quora.mapper.ModifyAnswerMapper;
import com.quora.service.business.AnswerManagementService;
import com.quora.service.models.request.AnswerInputDTO;
import com.quora.service.models.request.ModifyAnswerInputDTO;
import com.quora.service.models.response.AnswerOutputDTO;
import com.quora.service.models.response.ModifyAnswerOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1")
public class AnswerManagementController {
    private AnswerManagementService answerManagementService;
    private AnswerManagementMapper answerManagementMapper = AnswerManagementMapper.INSTANCE;
    private ModifyAnswerMapper modifyAnswerMapper = ModifyAnswerMapper.INSTANCE;

    @Autowired
    private AnswerManagementController (
            AnswerManagementService answerManagementService
    ) {
        this.answerManagementService = answerManagementService;
    }

    @PostMapping("/questions/{questionId}/answers")
    private ResponseEntity<AnswerResponseDTO> addAnswer(
            @RequestBody AnswerRequestDTO answerRequestDTO,
            @PathVariable UUID questionId
    ) {
        AnswerInputDTO inputDTO = answerManagementMapper.mapRequestToInputDTO(answerRequestDTO);
        inputDTO.setQuestionId(questionId);
        AnswerOutputDTO outputDTO = answerManagementService.postAnswer(inputDTO);
        AnswerResponseDTO responseDTO = answerManagementMapper.mapOutputToResponse(outputDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/answers/{answerId}")
    private ResponseEntity<ModifyAnswerResponseDTO> modifyAnswer(
            @RequestBody ModifyAnswerRequestDTO requestDTO,
            @PathVariable UUID answerId
    ) {
        ModifyAnswerInputDTO inputDTO = modifyAnswerMapper.mapRequestToInput(requestDTO);
        inputDTO.setAnswerId(answerId);
        ModifyAnswerOutputDTO outputDTO = answerManagementService.modifyAnswer(inputDTO);
        ModifyAnswerResponseDTO responseDTO = modifyAnswerMapper.mapOutputToResponse(outputDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
    }
}
