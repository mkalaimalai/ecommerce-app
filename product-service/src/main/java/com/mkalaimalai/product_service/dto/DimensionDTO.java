package com.mkalaimalai.product_service.dto;


import lombok.Data;

import java.math.BigDecimal;


@Data
public class DimensionDTO {

    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal depth;

}
