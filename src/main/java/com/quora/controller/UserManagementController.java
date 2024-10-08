package com.quora.controller;

import com.quora.apimodels.request.UserDetailsRequestDTO;
import com.quora.mapper.UserDetailsMapper;
import com.quora.service.business.UserManagementService;
import com.quora.service.models.request.UserDetailsInputDTO;
import com.quora.service.models.response.UserDetailsOutputDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class UserManagementController {

    private final UserManagementService userService;
    private final UserDetailsMapper userDetailsMapper = UserDetailsMapper.INSTANCE;
    @Autowired
    public UserManagementController(UserManagementService userService){
        this.userService = userService;
    }

    @Operation(summary = "Create a user", description = "Enables the user to create an Id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User successfully created."),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @PostMapping("/users")
    public ResponseEntity<UserDetailsOutputDTO> createUser (
            @RequestBody UserDetailsRequestDTO requestDTO
    ){
        UserDetailsInputDTO inputDTO = userDetailsMapper.mapRequestToInput(requestDTO);
        UserDetailsOutputDTO outputDTO = userService.createUserDetails(inputDTO);
        return new ResponseEntity<>(outputDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Fetch user details", description = "Enables the user to fetch their details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User successfully fetched."),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @GetMapping("/users/{username}")
    public ResponseEntity<UserDetailsOutputDTO> fetchUser(
            @PathVariable String username
    ) {
        UserDetailsInputDTO inputDTO = new UserDetailsInputDTO();
        inputDTO.setUsername(username);
        UserDetailsOutputDTO outputDTO = userService.fetchUserDetails(inputDTO);
        return new ResponseEntity<>(outputDTO, HttpStatus.OK);
    }

    @Operation(summary = "Update a user", description = "Enables the user to update their details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User successfully updated."),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
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
