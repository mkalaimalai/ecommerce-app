package com.mkalaimalai.product_service.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "ProductDiscount")
public class ProductInventory {

    @Id
    private UUID id;
    private Long quantity;

}
