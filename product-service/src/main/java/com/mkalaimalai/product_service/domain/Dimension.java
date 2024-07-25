package com.mkalaimalai.product_service.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.UUID;


@Data
public class Dimension {

    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal depth;

}
