package com.backend.pragma_aws_services.crud.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerInDTO {

    @NotNull(message = "Name is required")
    private String name;

    @NotNull(message = "Last Name is required")
    private String lastName;

    @NotNull(message = "Email is required")
    private String documentId;
}
