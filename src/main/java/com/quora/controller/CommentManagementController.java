package com.quora.controller;

import com.quora.apimodels.request.CommentOnCommentRequestDTO;
import com.quora.apimodels.request.CommentRequestDTO;
import com.quora.apimodels.response.CommentOnCommentResponseDTO;
import com.quora.mapper.CommentManagementMapper;
import com.quora.mapper.CommentOnCommentMapper;
import com.quora.service.business.CommentManagementService;
import com.quora.service.models.request.CommentInputDTO;
import com.quora.service.models.request.CommentOnCommentInputDTO;
import com.quora.service.models.response.CommentOnCommentOutputDTO;
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
    private final CommentOnCommentMapper commentOnCommentMapper = CommentOnCommentMapper.INSTANCE;
    private final CommentManagementService commentManagementService;
    @Autowired
    private CommentManagementController(CommentManagementService commentManagementService){
        this.commentManagementService = commentManagementService;
    }

    @PostMapping("/answer/{answerId}/comments")
    public ResponseEntity<CommentOutputDTO> commentMethod(
            @PathVariable UUID answerId,
            @RequestBody CommentRequestDTO requestDTO
    ) {
        CommentInputDTO inputDTO = commentManagementMapper.mapRequestToInput(requestDTO);
        inputDTO.setAnswerId(answerId);
        CommentOutputDTO outputDTO = commentManagementService.doComment(inputDTO);
        return new ResponseEntity<>(outputDTO, HttpStatus.ACCEPTED);
    }

    @PostMapping("/comments/{commentId}/comments")
    public ResponseEntity<CommentOnCommentResponseDTO> commentOnComment(
            @PathVariable UUID commentId,
            @RequestBody CommentOnCommentRequestDTO requestDTO
    ) {
        CommentOnCommentInputDTO inputDTO = commentOnCommentMapper.mapRequestToInput(requestDTO);
        inputDTO.setParentCommentId(commentId);
        CommentOnCommentOutputDTO outputDTO= commentManagementService.doCommOnComment(inputDTO);
        CommentOnCommentResponseDTO responseDTO = commentOnCommentMapper.mapOutputToResponse(outputDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
    }
}
