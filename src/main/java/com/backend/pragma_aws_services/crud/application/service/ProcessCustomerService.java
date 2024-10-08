package com.backend.pragma_aws_services.crud.application.service;

import com.backend.pragma_aws_services.crud.application.dto.CustomerInDTO;
import com.backend.pragma_aws_services.crud.domain.entities.CustomerEntity;
import com.backend.pragma_aws_services.crud.infraestructure.adapters.ports.in.ProcessCustomerPort;
import com.backend.pragma_aws_services.crud.infraestructure.adapters.ports.out.CustomerRepositoryPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProcessCustomerService implements ProcessCustomerPort {

    private static final Logger logger = LoggerFactory.getLogger(ProcessCustomerService.class);

    private final CustomerRepositoryPort customerRepositoryPort;

    public ProcessCustomerService(CustomerRepositoryPort customerRepositoryPort) {
        this.customerRepositoryPort = customerRepositoryPort;
    }


    @Override
    public ResponseEntity<?> createCustomer(CustomerInDTO customerInDTO) {
        logger.info(">> Starting Service createCustomer");

        CustomerEntity customerEntity = mapToEntity(customerInDTO);

        customerRepositoryPort.saveCustomer(customerEntity);

        return ResponseEntity.ok("CustomerId:  " + customerEntity.getId() + " created successfully");
    }

    // Mapping DTO to Entity
    private CustomerEntity mapToEntity(CustomerInDTO customerInDTO) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(UUID.randomUUID().toString());
        customerEntity.setFullName(customerInDTO.getFullName());
        customerEntity.setDocumentId(customerInDTO.getDocumentId());
        return customerEntity;
    }
}
