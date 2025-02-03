package com.mkalaimalai.product_service.valueobject;

import com.mkalaimalai.common.valueobject.BaseID;

import java.util.UUID;

public class CustomerId extends BaseID<UUID> {

    public CustomerId(UUID value) {
        super(value);
    }
}
