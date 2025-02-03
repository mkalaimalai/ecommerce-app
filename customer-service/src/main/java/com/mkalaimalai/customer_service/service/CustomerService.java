package com.mkalaimalai.customer_service.service;

import com.mkalaimalai.customer_service.domain.Address;
import com.mkalaimalai.customer_service.domain.Customer;
import com.mkalaimalai.customer_service.dto.CustomerDTO;
import com.mkalaimalai.customer_service.exception.ResourceNotFoundException;
import com.mkalaimalai.customer_service.mapper.CustomerMapper;
import com.mkalaimalai.customer_service.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);


    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDTO createCustomer(CustomerDTO customer) {
        Customer customerEntity = CustomerMapper.INSTANCE.toEntity(customer);
        if (customerEntity.getAddresses() != null) {
            for (Address address : customerEntity.getAddresses()) {
                address.setCustomer(customerEntity);
            }
        }
//        customerEntity.setCustomerId(UUID.randomUUID());
        Customer savedCustomer = customerRepository.save(customerEntity);
        return CustomerMapper.INSTANCE.toDTO(savedCustomer);

    }

    public Customer findById(UUID id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.get();
    }

    public CustomerDTO findCustomerById(UUID id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return CustomerMapper.INSTANCE.toDTO(customer.get());
    }


    public CustomerDTO updateUser(UUID id, CustomerDTO customerDTO) {
        Optional<Customer> customer = Optional.ofNullable(findById(id));
        if (customer == null) {
            logger.error("Unable to update. User with id {} not found.", id);
            throw new ResourceNotFoundException(id, "user not found");
        }
        Customer updatedCustomer = CustomerMapper.INSTANCE.toEntity(customerDTO);
        updatedCustomer.setCustomerId(id);
        if (updatedCustomer.getAddresses() != null) {
            for (Address address : updatedCustomer.getAddresses()) {
                address.setCustomer(updatedCustomer);
            }
        }
        Customer savedCustomer = customerRepository.save(updatedCustomer);
        return CustomerMapper.INSTANCE.toDTO(savedCustomer);
    }


    public Page<CustomerDTO> getAllCustomers(Pageable pageable) {
        Page<Customer> customers = customerRepository.findAll(pageable);
        if (customers.getContent().isEmpty()) {
            throw new ResourceNotFoundException(ResourceNotFoundException.Resource.Customer, "Customers not found");
        }
        int totalElements = (int) customers.getTotalElements();
        return new PageImpl<CustomerDTO>(customers.getContent().stream()
                .map(customer -> CustomerMapper.INSTANCE.toDTO(customer))
                .collect(Collectors.toList()), pageable, totalElements);
    }

    public void deleteCustomer(UUID id) {
        Customer customer = findById(id);
        if (customer == null) {
            logger.error("unable to delete. customer with id {} not found.", id);
            throw new ResourceNotFoundException(id, "customer not found");
        }
        customerRepository.delete(customer);
    }

    public void deleteAllCustomers() {
        customerRepository.deleteAll();
    }


}
