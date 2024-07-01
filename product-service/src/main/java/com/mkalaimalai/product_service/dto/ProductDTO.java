package com.mkalaimalai.product_service.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProductDTO {

    @Id
    private UUID id;
    private String name;
    private String description;
    private String SKU;
    private BigDecimal price;
    private ProductCategoryDTO category;
}
