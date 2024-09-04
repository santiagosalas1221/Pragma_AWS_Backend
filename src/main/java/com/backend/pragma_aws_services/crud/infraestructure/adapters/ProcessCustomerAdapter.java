package com.backend.pragma_aws_services.crud.infraestructure.adapters;

import com.backend.pragma_aws_services.crud.domain.entities.CustomerEntity;
import com.backend.pragma_aws_services.crud.domain.repository.JpaCustomerRepository;
import com.backend.pragma_aws_services.crud.infraestructure.adapters.ports.out.CustomerRespositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcessCustomerAdapter implements CustomerRespositoryPort {


    private final JpaCustomerRepository jpaCustomerRepository;

    @Autowired
    public ProcessCustomerAdapter(JpaCustomerRepository jpaCustomerRepository) {
        this.jpaCustomerRepository = jpaCustomerRepository;
    }

    @Override
    public void saveCustomer(CustomerEntity customerEntity) {
        jpaCustomerRepository.save(customerEntity);
    }
}