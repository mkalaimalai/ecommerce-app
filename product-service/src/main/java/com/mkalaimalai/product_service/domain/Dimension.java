package com.mkalaimalai.product_service.domain;


import lombok.Data;

import java.math.BigDecimal;


@Data
public class Dimension {

    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal depth;

}
