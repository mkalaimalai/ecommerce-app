package com.mkalaimalai.customer_service.controller;


import com.mkalaimalai.customer_service.dto.CustomerDTO;
import com.mkalaimalai.customer_service.service.CustomerService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/customers")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @CachePut(value = "customers", key = "'customer:'+ #customerId")
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customer) {
        log.debug("Creating customer with email = {}", customer.getEmail());
        CustomerDTO savedCustomer = customerService.createCustomer(customer);
        log.debug("Created customer with email = {}", savedCustomer.getEmail());
        return savedCustomer;
    }


    @RequestMapping(value = "/{customer_id}", method = RequestMethod.GET)
    @ResponseBody
    @Cacheable(value = "customers", key = "'customer:'+#customerId")
    public CustomerDTO getUser(@PathVariable("customer_id") String id) {
        log.info("getting customer with id {}", id);
        CustomerDTO customerDTO = customerService.findCustomerById(UUID.fromString(id));
        return customerDTO;
    }

    @RequestMapping(value = "/{customer_id}", method = RequestMethod.PUT)
    @ResponseBody
    @CachePut(value = "customers", key = "'customer:'+#customerId")
    @CacheEvict(value = "customers", key = "'all_customers'")
    public CustomerDTO updateCustomer(@PathVariable("customer_id") String customerId, @RequestBody @Valid CustomerDTO customer) {
        log.info("updating customer with id {}", customerId);
        CustomerDTO updatedCustomerVO = customerService.updateUser(UUID.fromString(customerId), customer);
        log.info("updated customer with id {}", customerId);
        return updatedCustomerVO;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Page<CustomerDTO> getAllCustomers(
            @RequestParam(value = "page", required = true, defaultValue = "0") Integer page,
            @RequestParam(value = "size", required = true, defaultValue = "10") Integer size) {
        log.debug("Getting all the customers data");
        return customerService.getAllCustomers(PageRequest.of(page, size));
    }

    @RequestMapping(value = "/{customer_id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @CacheEvict(value = "customers", allEntries = true)
    public void deleteCustomer(@PathVariable("customer_id") String customerId) {
        log.info("fetching & deleting Customer with id {}", customerId);
        customerService.deleteCustomer(UUID.fromString(customerId));
        log.info("deleted customer with id {}", customerId);
    }


    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @CacheEvict(value = "customers", allEntries = true)
    public void deleteAllCustomers() {
        log.info("deleting all customers");
        customerService.deleteAllCustomers();
        log.info("deleted all customers");
    }


}
