package com.quora.controller;

import com.quora.apimodels.request.LikeRequestDTO;
import com.quora.apimodels.response.LikeResponseDTO;
import com.quora.mapper.LikeManagementMapper;
import com.quora.service.business.LikeManagementService;
import com.quora.service.models.request.LikeInputDTO;
import com.quora.service.models.response.LikeOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1")
public class LikeManagementController {

    private final LikeManagementService likeManagementService;
    private final LikeManagementMapper likeManagementMapper = LikeManagementMapper.INSTANCE;

    @Autowired
    private LikeManagementController(
            LikeManagementService likeManagementService
    ) {
        this.likeManagementService = likeManagementService;
    }

    @PostMapping("/{type}/{id}/like")
    private ResponseEntity<LikeResponseDTO> like(
            @PathVariable String type,
            @PathVariable UUID id,
            @RequestBody LikeRequestDTO requestDTO
    ) {
        LikeInputDTO inputDTO = likeManagementMapper.mapRequestToInput(requestDTO);
        inputDTO.setId(id);
        inputDTO.setType(type);
        LikeOutputDTO outputDTO = likeManagementService.doLike(inputDTO);
        LikeResponseDTO responseDTO = likeManagementMapper.mapOutputToResponse(outputDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
