package com.backend.pragma_aws_services.crud.infraestructure.adapters.ports.in;

import com.backend.pragma_aws_services.crud.application.dto.CustomerInDTO;
import org.springframework.http.ResponseEntity;

public interface ProcessCustomerPort {
    ResponseEntity<?> createCustomer(CustomerInDTO customerInDTO);
}
