package com.mkalaimalai.order_service.mapper;


import com.mkalaimalai.order_service.domain.Address;
import com.mkalaimalai.order_service.domain.Customer;
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
    public CustomerDTO toDTO(Customer entity) ;

    @Mapping(source="id", target="id")
    public Customer toEntity(CustomerDTO dto) ;

    @Mapping(source="line1", target="line1")
    public AddressDTO toDTO(Address entity) ;

    @Mapping(source="line1", target="line1")
    public Address toEntity(AddressDTO dto) ;


    public List<AddressDTO> createAddressVOList(List<Address> addresses) ;

    public List<Address> createAddressList(List<AddressDTO> addresses) ;


}
