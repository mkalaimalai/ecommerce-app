package com.mkalaimalai.product_service.dto;

import com.mkalaimalai.product_service.domain.Dimension;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class ProductDTO {

    @Id
    private UUID id;
    private String title;
    private String description;
    private String SKU;
    private BigDecimal price;
    private BigDecimal quantity;
    private BigDecimal discountPercentage;
    private String category;
    private BigDecimal rating;
    private List<String> tags;
    private String brand;
    private BigDecimal weight;
    private Dimension dimensions;
}
