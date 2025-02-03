package com.mkalaimalai.order_service.dto;

import com.mkalaimalai.order_service.domain.Cart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private UUID orderId;

    private LocalDateTime orderDate;

    private String orderDesc;

    private Double orderFee;

    private Cart cart;

}
