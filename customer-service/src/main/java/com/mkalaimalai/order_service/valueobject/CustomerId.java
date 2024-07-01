package com.mkalaimalai.order_service.valueobject;

import com.mkalaimalai.common.valueobject.BaseId;

import java.util.UUID;

public class CustomerId extends BaseId<UUID> {

    public CustomerId(UUID value){
        super(value);
    }
}
