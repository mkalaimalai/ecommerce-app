package com.mkalaimalai.product_service.valueobject;

import com.mkalaimalai.common.valueobject.BaseId;
import lombok.Data;

import java.util.UUID;

public class CustomerId extends BaseId<UUID> {

    public CustomerId(UUID value){
        super(value);
    }
}
