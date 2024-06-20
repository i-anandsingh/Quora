package com.quora.controller;

import com.quora.apimodels.response.FollowResponseDTO;
import com.quora.mapper.FollowManagementMapper;
import com.quora.service.business.FollowManagementService;
import com.quora.service.models.request.FollowInputDTO;
import com.quora.service.models.response.FollowOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class FollowManagementController {
    private final FollowManagementService followManagementService;
    private final FollowManagementMapper followManagementMapper = FollowManagementMapper.INSTANCE;

    @Autowired
    private FollowManagementController(
            FollowManagementService followManagementService
    ) {
        this.followManagementService = followManagementService;
    }

    @PostMapping("/users/{userId}/follow/{targetId}")
    private ResponseEntity<FollowResponseDTO> followUsers(
            @PathVariable String userId,
            @PathVariable String targetId
    ) {
        FollowInputDTO inputDTO = new FollowInputDTO();
        inputDTO.setFollower(userId);
        inputDTO.setFollowing(targetId);
        FollowOutputDTO outputDTO = followManagementService.doFollow(inputDTO);
        FollowResponseDTO responseDTO = followManagementMapper.mapOutputToResponse(outputDTO);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }
}
