package com.quora.controller;

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

    @Autowired
    private FollowManagementController(
            FollowManagementService followManagementService
    ) {
        this.followManagementService = followManagementService;
    }

    @PostMapping("/users/{userName}/follow/{targetUserName}")
    private ResponseEntity<FollowOutputDTO> followUsers(
            @PathVariable String userName,
            @PathVariable String targetUserName
    ) {
        FollowInputDTO inputDTO = new FollowInputDTO();
        inputDTO.setFollower(userName);
        inputDTO.setFollowing(targetUserName);
        FollowOutputDTO outputDTO = followManagementService.doFollow(inputDTO);
        return new ResponseEntity<>(outputDTO, HttpStatus.OK);
    }
}
