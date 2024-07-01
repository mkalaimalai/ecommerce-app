package com.mkalaimalai.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private UUID id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private List<AddressDTO> addresses;
    
}
