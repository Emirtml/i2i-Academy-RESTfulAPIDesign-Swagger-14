package com.i2i.customer_management.controller;

import com.i2i.customer_management.dto.CustomerDTO;
import com.i2i.customer_management.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@Tag(name = "Customer Management", description = " Fernandez API endpoints for Customer CRUD operations")
public class CustomerController {

    // Inject Service layer to handle business logic
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // 1. CREATE: Post a new customer
    @PostMapping
    @Operation(summary = "Create a new customer", description = "Saves a new customer to the Oracle database")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.createCustomer(customerDTO));
    }

    // 2. RETRIEVE BY ID: Get a single customer by their ID
    @GetMapping("/{id}")
    @Operation(summary = "Get customer by ID", description = "Returns a single customer DTO using their unique ID")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    // 3. RETRIEVE ALL: Get a list of all existing customers
    @GetMapping
    @Operation(summary = "Get all customers", description = "Returns a list of all customers stored in the system")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    // 4. UPDATE: Modify details of an existing customer
    @PutMapping("/{id}")
    @Operation(summary = "Update an existing customer", description = "Updates customer details based on the provided ID")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customerDTO));
    }

    // 5. DELETE: Remove a customer from the database
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a customer", description = "Removes a customer permanently from the database")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
