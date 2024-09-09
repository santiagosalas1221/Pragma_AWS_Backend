package com.backend.pragma_aws_services.crud.infraestructure.controllers;

import com.backend.pragma_aws_services.crud.application.dto.CustomerInDTO;
import com.backend.pragma_aws_services.crud.infraestructure.adapters.ports.in.ProcessCustomerPort;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pragma/project/customer")
public class CrudProjectController {

    private  static  final Logger logger = LoggerFactory.getLogger(CrudProjectController.class);
    private final ProcessCustomerPort processCustomerPort;

    @Autowired
    public CrudProjectController(ProcessCustomerPort processCustomerPort) {
        this.processCustomerPort = processCustomerPort;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@Valid @RequestBody CustomerInDTO customerInDTO) {
        logger.info(">> Starting Controller createCustomer");



        return processCustomerPort.createCustomer(customerInDTO);
    }
}
