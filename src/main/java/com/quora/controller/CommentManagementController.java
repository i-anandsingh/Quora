package com.quora.controller;

import com.quora.apimodels.request.CommentRequestDTO;
import com.quora.apimodels.response.CommentResponseDTO;
import com.quora.mapper.CommentManagementMapper;
import com.quora.service.business.CommentManagementService;
import com.quora.service.models.request.CommentInputDTO;
import com.quora.service.models.response.CommentOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1")
public class CommentManagementController {
    private final CommentManagementMapper commentManagementMapper = CommentManagementMapper.INSTANCE;
    private final CommentManagementService commentManagementService;
    @Autowired
    private CommentManagementController(CommentManagementService commentManagementService){
        this.commentManagementService = commentManagementService;
    }

    @PostMapping("/answer/{answerId}/comments")
    public ResponseEntity<CommentResponseDTO> commentMethod(
            @PathVariable UUID answerId,
            @RequestBody CommentRequestDTO requestDTO
    ) {
        CommentInputDTO inputDTO = commentManagementMapper.mapRequestToInput(requestDTO);
        inputDTO.setAnswerId(answerId);
        CommentOutputDTO outputDTO = commentManagementService.commentOnAnswer(inputDTO);
        CommentResponseDTO response = commentManagementMapper.mapOutputToResponse(outputDTO);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
