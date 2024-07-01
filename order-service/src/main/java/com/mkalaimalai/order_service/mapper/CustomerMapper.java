package com.mkalaimalai.order_service.mapper;


import com.mkalaimalai.order_service.domain.Cart;
import com.mkalaimalai.order_service.domain.Order;
import com.mkalaimalai.order_service.dto.AddressDTO;
import com.mkalaimalai.order_service.dto.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source="id", target="id")
    public CustomerDTO toDTO(Order entity) ;

    @Mapping(source="id", target="id")
    public Order toEntity(CustomerDTO dto) ;

    @Mapping(source="line1", target="line1")
    public AddressDTO toDTO(Cart entity) ;

    @Mapping(source="line1", target="line1")
    public Cart toEntity(AddressDTO dto) ;


    public List<AddressDTO> createAddressVOList(List<Cart> addresses) ;

    public List<Cart> createAddressList(List<AddressDTO> addresses) ;


}
