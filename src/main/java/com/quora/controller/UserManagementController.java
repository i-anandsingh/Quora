package com.quora.controller;

import com.quora.apimodels.request.UserDetailsRequestDTO;
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
    public ResponseEntity<UserDetailsOutputDTO> createUser (
            @RequestBody UserDetailsRequestDTO requestDTO
    ){
        UserDetailsInputDTO inputDTO = userDetailsMapper.mapRequestToInput(requestDTO);
        UserDetailsOutputDTO outputDTO = userService.createUserDetails(inputDTO);
        return new ResponseEntity<>(outputDTO, HttpStatus.CREATED);
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<UserDetailsOutputDTO> fetchUser(
            @PathVariable String username
    ) {
        UserDetailsInputDTO inputDTO = new UserDetailsInputDTO();
        inputDTO.setUsername(username);
        UserDetailsOutputDTO outputDTO = userService.fetchUserDetails(inputDTO);
        return new ResponseEntity<>(outputDTO, HttpStatus.OK);
    }

    @PutMapping("/users/{username}")
    public ResponseEntity<UserDetailsOutputDTO> updateUser(
            @RequestBody UserDetailsRequestDTO requestDTO,
            @PathVariable String username
    ){
        UserDetailsInputDTO inputDTO = userDetailsMapper.mapRequestToInput(requestDTO);
        inputDTO.setUsername(username);
        UserDetailsOutputDTO outputDTO = userService.updateUserDetails(inputDTO);
        return new ResponseEntity<>(outputDTO, HttpStatus.ACCEPTED);
    }
}
