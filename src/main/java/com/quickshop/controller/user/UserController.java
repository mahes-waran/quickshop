package com.quickshop.controller.user;

import com.quickshop.model.user.Address;
import com.quickshop.model.user.CreateUserRequest;
import com.quickshop.model.user.UserResponse;
import com.quickshop.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(name = "E-Commerce User Management API", description = "Endpoints for customer registration, profile management, and shipping/billing addresses.")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @Operation(summary = "Register new customer", description = "Creates a new customer account for the e-commerce platform.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "User created successfully",
                    content = @Content(schema = @Schema(implementation = UserResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request payload or email already exists")
    })
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody CreateUserRequest request) {
        UserResponse createdUser = userService.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/{userId}")
    @Operation(summary = "Get User Profile", description = "Retrieves customer profile information by User ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User profile retrieved successfully",
                    content = @Content(schema = @Schema(implementation = UserResponse.class))),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<UserResponse> getUserById(
            @Parameter(description = "ID of the user", required = true, example = "1001")
            @PathVariable Long userId) {
        UserResponse user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/{userId}/addresses")
    @Operation(summary = "Add customer address", description = "Adds a shipping or billing address to a user profile.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Address added successfully",
                    content = @Content(schema = @Schema(implementation = Address.class))),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<Address> addAddress(
            @Parameter(description = "ID of the user", required = true, example = "1001")
            @PathVariable Long userId,
            @Valid @RequestBody Address address) {
        Address addedAddress = userService.addAddress(userId, address);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedAddress);
    }

    @GetMapping("/{userId}/addresses")
    @Operation(summary = "Get customer addresses", description = "Fetches all shipping and billing addresses linked to a customer.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of user addresses retrieved successfully")
    })
    public ResponseEntity<List<Address>> getUserAddresses(
            @Parameter(description = "ID of the user", required = true, example = "1001")
            @PathVariable Long userId) {
        List<Address> addresses = userService.getUserAddresses(userId);
        return ResponseEntity.ok(addresses);
    }
}