package com.mkalaimalai.order_service.dto;

import com.mkalaimalai.order_service.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {

    private Long cartId;
    private Integer userId;
    private Set<Order> orders;
}
