package com.mkalaimalai.product_service.controller;


import com.mkalaimalai.product_service.dto.ProductDTO;
import com.mkalaimalai.product_service.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO createProduct(@RequestBody ProductDTO product){
        log.debug("Creating product with name = {}", product.getTitle());
        ProductDTO savedProduct = productService.createProduct(product);
        log.debug("Created product with email = {}", savedProduct.getTitle());
        return savedProduct;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Page<ProductDTO> getAllProducts(
            @RequestParam( value= "page", required=true, defaultValue = "0") Integer page,
            @RequestParam(value= "size", required=true, defaultValue = "10") Integer size){
        log.debug("Getting all the products data");
        return productService.getAllProducts(PageRequest.of(page, size));
    }



}
