package com.mkalaimalai.product_service.repository;



import com.mkalaimalai.product_service.domain.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSearchRepository extends ElasticsearchRepository<Product, String> {


}
