package com.backend.pragma_aws_services.crud.application.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerInDTO {

    @NotNull(message = "Name is required")
    private String fullName;

    @NotNull(message = "Document Id is required")
    private String documentId;
}
