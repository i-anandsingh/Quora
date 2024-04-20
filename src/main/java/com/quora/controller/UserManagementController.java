package com.quora.controller;

import com.quora.apimodels.request.UserDetailsRequestDTO;
import com.quora.apimodels.response.UserDetailsResponseDTO;
import com.quora.mapper.UserDetailsMapper;
import com.quora.service.business.UserManagementService;
import com.quora.service.models.request.UserDetailsInputDTO;
import com.quora.service.models.response.UserDetailsOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class UserManagementController {

    private final UserManagementService userService;
    private UserDetailsMapper userDetailsMapper = UserDetailsMapper.INSTANCE;
    @Autowired
    public UserManagementController(UserManagementService userService){
        this.userService = userService;
    }
    @PostMapping("/users")
    public ResponseEntity<UserDetailsResponseDTO> createUser (@RequestBody UserDetailsRequestDTO requestDTO){
        UserDetailsInputDTO inputDTO = userDetailsMapper.mapRequestToInput(requestDTO);
        UserDetailsOutputDTO outputDTO = userService.createUserDetails(inputDTO);
        UserDetailsResponseDTO responseDTO = userDetailsMapper.mapOutputToResponse(outputDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDetailsResponseDTO> fetchUser(@PathVariable String userId) {
        UserDetailsInputDTO inputDTO = new UserDetailsInputDTO();
        inputDTO.setUserId(userId);
        UserDetailsOutputDTO outputDTO = userService.fetchUserDetails(inputDTO);
        UserDetailsResponseDTO responseDTO = userDetailsMapper.mapOutputToResponse(outputDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<UserDetailsResponseDTO> updateUser(@RequestBody UserDetailsRequestDTO requestDTO){
        UserDetailsInputDTO inputDTO = userDetailsMapper.mapRequestToInput(requestDTO);
        UserDetailsOutputDTO outputDTO = userService.updateUserDetails(inputDTO);
        UserDetailsResponseDTO responseDTO = userDetailsMapper.mapOutputToResponse(outputDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
    }
}
