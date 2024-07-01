package com.mkalaimalai.product_service.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "ProductCategory")
public class ProductCategory {

    @Id
    private UUID id;
    private String name;
    private String description;
}
