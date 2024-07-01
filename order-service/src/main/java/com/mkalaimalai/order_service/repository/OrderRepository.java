package com.mkalaimalai.order_service.repository;

import com.mkalaimalai.order_service.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	
	
}
