package com.backend.pragma_aws_services.crud.infraestructure.adapters.ports.out;

import com.backend.pragma_aws_services.crud.domain.entities.CustomerEntity;

public interface CustomerRespositoryPort {

    void saveCustomer(CustomerEntity customer);
}
