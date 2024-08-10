package com.quora.apimodels.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "User Details RequestDTO")
public class UserDetailsRequestDTO {
    @Schema(name = "username", example = "iamanand", required = true, description = "User name of the user.")
    private String username;
    @Schema(name = "emailId", example = "anyemail@xyz.com", required = true, description = "Email Id of the user.")
    private String emailId;
    @Schema(name = "bio", example = "My name is Anand.", required = false, description = "Bio of the user.")
    private String bio;
}
