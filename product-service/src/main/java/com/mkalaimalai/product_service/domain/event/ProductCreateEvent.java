package com.mkalaimalai.product_service.domain.event;

import com.mkalaimalai.product_service.domain.Product;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;


@Data
public class ProductCreateEvent {

    private final UUID productId;
    private final List<String> failureMessages;
    private final ZonedDateTime createdAt;
    private final Product product;
}
