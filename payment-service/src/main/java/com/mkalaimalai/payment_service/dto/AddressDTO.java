package com.mkalaimalai.payment_service.dto;

import com.mkalaimalai.payment_service.domain.AddressType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    private String line1;
    private String line2;
    private String city;
    private String country;
    private String zip;
    private AddressType type;
}
