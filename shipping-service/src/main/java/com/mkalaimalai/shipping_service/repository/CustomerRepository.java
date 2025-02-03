package com.mkalaimalai.order_service.repository;


import com.mkalaimalai.order_service.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, UUID>, CrudRepository<Customer, UUID> {
    public Customer findByUserName(String userName);

    public Page<Customer> findAll(Pageable pageable);
}
