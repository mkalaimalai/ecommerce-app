package com.mkalaimalai.order_service.repository;

import com.mkalaimalai.order_service.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	
	
	
}
