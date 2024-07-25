package com.mkalaimalai.product_service.service;

import com.mkalaimalai.product_service.domain.Product;
import com.mkalaimalai.product_service.dto.ProductDTO;
import com.mkalaimalai.product_service.exception.ResourceNotFoundException;
import com.mkalaimalai.product_service.mapper.ProductMapper;
import com.mkalaimalai.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductDTO createProduct(ProductDTO productDTO){
        Product productEntity = ProductMapper.INSTANCE.toProductEntity(productDTO);
        Product savedProduct = productRepository.save(productEntity);
        return ProductMapper.INSTANCE.toProductDTO(savedProduct);

    }

    public Page<ProductDTO> getAllProducts(Pageable pageable){



        Page<Product> products = productRepository.findAll(pageable);

        if(products.getContent().isEmpty()){
            throw new ResourceNotFoundException(ResourceNotFoundException.Resource.Product, "Products not found");
        }

        int totalElements = (int) products.getTotalElements();

        return new PageImpl<ProductDTO>(products.getContent().stream()
                .map(product -> ProductMapper.INSTANCE.toProductDTO(product))
                .collect(Collectors.toList()),  pageable, totalElements );



    }
}
