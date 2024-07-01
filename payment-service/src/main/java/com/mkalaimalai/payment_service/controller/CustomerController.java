package com.mkalaimalai.payment_service.controller;


import com.mkalaimalai.payment_service.dto.CustomerDTO;
import com.mkalaimalai.payment_service.service.CustomerService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customers")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customer){
        log.debug("Creating customer with email = {}", customer.getEmail());
        CustomerDTO savedCustomer = customerService.createCustomer(customer);
        log.debug("Created customer with email = {}", savedCustomer.getEmail());
        return savedCustomer;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Page<CustomerDTO> getAllCustomers(
            @RequestParam( value= "page", required=true, defaultValue = "0") Integer page,
            @RequestParam(value= "size", required=true, defaultValue = "10") Integer size){
        log.debug("Getting all the customers data");
        return customerService.getAllCustomers(PageRequest.of(page, size));
    }



}
