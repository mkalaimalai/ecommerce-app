package com.mkalaimalai.order_service.service;

import com.mkalaimalai.order_service.domain.Address;
import com.mkalaimalai.order_service.domain.Customer;
import com.mkalaimalai.order_service.dto.CustomerDTO;
import com.mkalaimalai.order_service.exception.ResourceNotFoundException;
import com.mkalaimalai.order_service.mapper.CustomerMapper;
import com.mkalaimalai.order_service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDTO createCustomer(CustomerDTO customer){
        Customer customerEntity = CustomerMapper.INSTANCE.toEntity(customer);
        if(customerEntity.getAddresses() !=null) {
            for (Address address : customerEntity.getAddresses()) {
                address.setCustomer(customerEntity);
            }
        }

        Customer savedCustomer = customerRepository.save(customerEntity);
        return CustomerMapper.INSTANCE.toDTO(savedCustomer);

    }

    public Page<CustomerDTO> getAllCustomers(Pageable pageable){

        Page<Customer> customers = customerRepository.findAll(pageable);

        if(customers.getContent().isEmpty()){
            throw new ResourceNotFoundException(ResourceNotFoundException.Resource.Customer, "Customers not found");
        }

        int totalElements = (int) customers.getTotalElements();

        return new PageImpl<CustomerDTO>(customers.getContent().stream()
                .map(customer -> CustomerMapper.INSTANCE.toDTO(customer))
                .collect(Collectors.toList()),  pageable, totalElements );



    }
}
