package com.mkalaimalai.product_service.repository;




import com.mkalaimalai.product_service.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, UUID>, MongoRepository<Product, UUID> {
}
