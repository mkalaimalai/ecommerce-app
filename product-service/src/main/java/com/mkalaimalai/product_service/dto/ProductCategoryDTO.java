package com.mkalaimalai.product_service.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class ProductCategoryDTO {

    @Id
    private UUID id;
    private String name;
    private String description;
}
