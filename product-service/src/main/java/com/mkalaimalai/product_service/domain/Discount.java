package com.mkalaimalai.product_service.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.UUID;


@Data
public class Discount {

    @Id
    private UUID id;
    private String name;
    private String description;
    private BigDecimal discountPercent;
    private boolean active;

}
