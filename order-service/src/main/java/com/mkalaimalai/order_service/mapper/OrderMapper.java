package com.mkalaimalai.order_service.mapper;


import com.mkalaimalai.order_service.domain.Cart;
import com.mkalaimalai.order_service.domain.Order;
import com.mkalaimalai.order_service.dto.CartDTO;
import com.mkalaimalai.order_service.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(source = "orderId", target = "orderId")
    public OrderDTO toDTO(Order entity);

    @Mapping(source = "orderId", target = "orderId")
    public Order toEntity(OrderDTO dto);

    @Mapping(source = "cartId", target = "cartId")
    public CartDTO toDTO(Cart entity);

    @Mapping(source = "cartId", target = "cartId")
    public Cart toEntity(CartDTO dto);


}
