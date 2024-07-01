package com.mkalaimalai.product_service.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "Product")
public class Product {

    @Id
    private UUID id;
    private String name;
    private String description;
    private String SKU;
    private BigDecimal price;
    private ProductCategory category;
    private ProductInventory inventory;
    private Discount discount;
}
