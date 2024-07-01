package com.mkalaimalai.product_service.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
public class ProductInventoryDTO {

    @Id
    private UUID id;
    private Long quantity;

}
