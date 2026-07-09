package com.i2i.customer_management.service;

import com.i2i.customer_management.dto.CustomerDTO;
import com.i2i.customer_management.entity.Customer;
import com.i2i.customer_management.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    // Inject Repository layer to access database
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // 1. CREATE: Add a new customer to the database
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO.getFirstName(), customerDTO.getLastName(), customerDTO.getEmail());
        Customer savedCustomer = customerRepository.save(customer);
        return convertToDTO(savedCustomer);
    }

    // 2. RETRIEVE BY ID: Find a single customer using ID
    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
        return convertToDTO(customer);
    }

    // 3. RETRIEVE ALL: Get a list of all customers
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // 4. UPDATE: Change details of an existing customer
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer to update not found with ID: " + id));
        
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setEmail(customerDTO.getEmail());

        Customer updatedCustomer = customerRepository.save(customer);
        return convertToDTO(updatedCustomer);
    }

    // 5. DELETE: Remove a customer from the database
    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer to delete not found with ID: " + id));
        customerRepository.delete(customer);
    }

    // Helper method to convert Customer Entity into CustomerDTO
    private CustomerDTO convertToDTO(Customer customer) {
        return new CustomerDTO(customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getEmail());
    }
}