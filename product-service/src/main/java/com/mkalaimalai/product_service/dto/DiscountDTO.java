package com.mkalaimalai.product_service.dto;


import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;


@Data
public class DiscountDTO {

    private UUID id;
    private String name;
    private String description;
    private BigDecimal discountPercent;
    private boolean active;

}
