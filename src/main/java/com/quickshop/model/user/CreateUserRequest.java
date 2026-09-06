package com.quickshop.model.user;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "Request payload for creating/registering an e-commerce user")
public class CreateUserRequest {

    @NotBlank
    @Schema(description = "First Name", example = "John", requiredMode = Schema.RequiredMode.REQUIRED)
    private String firstName;

    @NotBlank
    @Schema(description = "Last Name", example = "Doe", requiredMode = Schema.RequiredMode.REQUIRED)
    private String lastName;

    @Email
    @NotBlank
    @Schema(description = "User Email", example = "john.doe@example.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @NotBlank
    @Schema(description = "Password", example = "Password123!", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;

    @Schema(description = "Mobile Phone Number", example = "+1234567890")
    private String phoneNumber;
}
