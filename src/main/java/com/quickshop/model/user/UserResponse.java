package com.quickshop.model.user;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Schema(description = "E-commerce user details response payload")
public class UserResponse {

    @Schema(description = "User ID", example = "1001")
    private Long id;

    @Schema(description = "First Name", example = "John")
    private String firstName;

    @Schema(description = "Last Name", example = "Doe")
    private String lastName;

    @Schema(description = "Email Address", example = "john.doe@example.com")
    private String email;

    @Schema(description = "Phone Number", example = "+1234567890")
    private String phoneNumber;

    @Schema(description = "Account Active Status", example = "true")
    private Boolean isEnabled;

    @Schema(description = "Account Creation Timestamp")
    private OffsetDateTime createdAt;
}
