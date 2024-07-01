package com.mkalaimalai.order_service.controller;


import com.mkalaimalai.order_service.dto.OrderDTO;
import com.mkalaimalai.order_service.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customers")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService customerService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO createCustomer(@RequestBody OrderDTO customer){
                return null;

    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Page<OrderDTO> getAllCustomers(){
        return null;

    }



}
