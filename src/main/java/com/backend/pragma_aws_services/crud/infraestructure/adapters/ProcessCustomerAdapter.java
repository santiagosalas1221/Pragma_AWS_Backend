package com.backend.pragma_aws_services.crud.infraestructure.adapters;

import com.backend.pragma_aws_services.crud.domain.entities.CustomerEntity;
import com.backend.pragma_aws_services.crud.domain.repository.DynamoDbCustomerRepository;
import com.backend.pragma_aws_services.crud.infraestructure.adapters.ports.out.CustomerRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessCustomerAdapter implements CustomerRepositoryPort {


    private final DynamoDbCustomerRepository dynamoDbCustomerRepository;

    @Autowired
    public ProcessCustomerAdapter(DynamoDbCustomerRepository dynamoDbCustomerRepository) {
        this.dynamoDbCustomerRepository = dynamoDbCustomerRepository;
    }

    @Override
    public void saveCustomer(CustomerEntity customerEntity) {
        dynamoDbCustomerRepository.save(customerEntity);
    }
}