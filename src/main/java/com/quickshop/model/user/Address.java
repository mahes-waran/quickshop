package com.quickshop.model.user;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "E-commerce user shipping/billing address payload")
public class Address {

    @Schema(description = "Address ID", example = "50")
    private Long id;

    @NotBlank
    @Schema(description = "Street Address Line 1", example = "123 Main St", requiredMode = Schema.RequiredMode.REQUIRED)
    private String streetLine1;

    @Schema(description = "Street Address Line 2", example = "Apt 4B")
    private String streetLine2;

    @NotBlank
    @Schema(description = "City", example = "New York", requiredMode = Schema.RequiredMode.REQUIRED)
    private String city;

    @NotBlank
    @Schema(description = "State/Province", example = "NY", requiredMode = Schema.RequiredMode.REQUIRED)
    private String state;

    @NotBlank
    @Schema(description = "Postal Code", example = "10001", requiredMode = Schema.RequiredMode.REQUIRED)
    private String postalCode;

    @NotBlank
    @Schema(description = "Country Code (ISO-2)", example = "US", requiredMode = Schema.RequiredMode.REQUIRED)
    private String country;

    @Schema(description = "Is Default Shipping Address", example = "true")
    private Boolean isDefaultShipping;

    @Schema(description = "Is Default Billing Address", example = "true")
    private Boolean isDefaultBilling;
}
