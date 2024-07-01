package com.mkalaimalai.payment_service.service;

import com.mkalaimalai.payment_service.domain.Address;
import com.mkalaimalai.payment_service.domain.Payment;
import com.mkalaimalai.payment_service.dto.CustomerDTO;
import com.mkalaimalai.payment_service.exception.ResourceNotFoundException;
import com.mkalaimalai.payment_service.mapper.CustomerMapper;
import com.mkalaimalai.payment_service.repository.CustomerRepository;
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
        Payment paymentEntity = CustomerMapper.INSTANCE.toEntity(customer);
        if(paymentEntity.getAddresses() !=null) {
            for (Address address : paymentEntity.getAddresses()) {
                address.setPayment(paymentEntity);
            }
        }

        Payment savedPayment = customerRepository.save(paymentEntity);
        return CustomerMapper.INSTANCE.toDTO(savedPayment);

    }

    public Page<CustomerDTO> getAllCustomers(Pageable pageable){

        Page<Payment> customers = customerRepository.findAll(pageable);

        if(customers.getContent().isEmpty()){
            throw new ResourceNotFoundException(ResourceNotFoundException.Resource.Customer, "Customers not found");
        }

        int totalElements = (int) customers.getTotalElements();

        return new PageImpl<CustomerDTO>(customers.getContent().stream()
                .map(customer -> CustomerMapper.INSTANCE.toDTO(customer))
                .collect(Collectors.toList()),  pageable, totalElements );



    }
}
