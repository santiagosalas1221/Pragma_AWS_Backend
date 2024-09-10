package com.backend.pragma_aws_services.crud.infraestructure.controllers;

import com.backend.pragma_aws_services.crud.application.dto.CustomerInDTO;
import com.backend.pragma_aws_services.crud.infraestructure.adapters.ports.in.ProcessCustomerPort;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/pragma/project/customer")
public class CrudProjectController {

    private static final Logger logger = LoggerFactory.getLogger(CrudProjectController.class);
    private final ProcessCustomerPort processCustomerPort;

    // Simulación de usuarios almacenados en memoria
    private static Map<String, CustomerInDTO> users = new HashMap<>();

    @Autowired
    public CrudProjectController(ProcessCustomerPort processCustomerPort) {
        this.processCustomerPort = processCustomerPort;
    }

    // Método para crear usuario usando la lógica de processCustomerPort
    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@Valid @RequestBody CustomerInDTO customerInDTO) {
        logger.info(">> Starting Controller createCustomer");
        return processCustomerPort.createCustomer(customerInDTO);
    }

    // Método para crear usuario simulando almacenamiento en memoria
    @PostMapping("/createLambda")
    public ResponseEntity<?> createCustomerLambda(@Valid @RequestBody CustomerInDTO customerInDTO) {
        logger.info(">> Starting Controller createCustomerLambda");

        String newId = UUID.randomUUID().toString();
        customerInDTO.setId(newId);

        // Simular almacenamiento en memoria
        users.put(newId, customerInDTO);

        return ResponseEntity.ok("User created with ID: " + newId);
    }


    @GetMapping("/getAll")
    public ResponseEntity<Map<String, CustomerInDTO>> getAllUsers() {
        logger.info(">> Starting Controller getAllUsers");
        return ResponseEntity.ok(users);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable String id, @Valid @RequestBody CustomerInDTO customerInDTO) {
        logger.info(">> Starting Controller updateCustomer");

        if (!users.containsKey(id)) {
            return ResponseEntity.badRequest().body("User not found with ID: " + id);
        }

        // Actualizar el usuario en memoria
        customerInDTO.setId(id); // Mantener el mismo ID
        users.put(id, customerInDTO);

        return ResponseEntity.ok("User updated with ID: " + id);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id) {
        logger.info(">> Starting Controller deleteCustomer");

        if (!users.containsKey(id)) {
            return ResponseEntity.badRequest().body("User not found with ID: " + id);
        }

        // Eliminar el usuario de la "base de datos" en memoria
        users.remove(id);

        return ResponseEntity.ok("User deleted with ID: " + id);
    }
}