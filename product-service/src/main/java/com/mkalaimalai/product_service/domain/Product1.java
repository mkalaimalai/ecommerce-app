package com.mkalaimalai.product_service.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@Builder
//@Document(indexName = "product")
public class Product1 {

    @Id
    private UUID id;
    private String title;
    private String description;
    private String SKU;
    private BigDecimal price;
    private BigDecimal discountPercentage;
    private String category;
    private BigDecimal quantity;
    private BigDecimal rating;
    private List<String> tags;
    private String brand;
    private BigDecimal weight;
    private Dimension dimensions;

    
}

