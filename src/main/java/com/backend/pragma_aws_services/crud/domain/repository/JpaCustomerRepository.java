package com.backend.pragma_aws_services.crud.domain.repository;

import com.backend.pragma_aws_services.crud.domain.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
