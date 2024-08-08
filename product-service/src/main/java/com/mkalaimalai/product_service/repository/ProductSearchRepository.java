package com.mkalaimalai.product_service.repository;




import com.mkalaimalai.product_service.domain.Product;
import com.mkalaimalai.product_service.domain.Product1;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductSearchRepository extends ElasticsearchRepository<Product1, String> {


}
