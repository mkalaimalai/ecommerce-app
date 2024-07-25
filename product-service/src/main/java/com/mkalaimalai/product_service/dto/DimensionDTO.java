package com.mkalaimalai.product_service.dto;


import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;


@Data
public class DimensionDTO {

    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal depth;

}
