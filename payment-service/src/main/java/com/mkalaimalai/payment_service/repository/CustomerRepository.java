package com.mkalaimalai.payment_service.repository;


import com.mkalaimalai.payment_service.domain.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Payment, UUID>, CrudRepository<Payment, UUID> {
    public Payment findByUserName(String userName);

    public Page<Payment> findAll(Pageable pageable);
}
