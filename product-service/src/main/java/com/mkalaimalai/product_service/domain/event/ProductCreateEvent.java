package com.mkalaimalai.product_service.domain.event;

import com.mkalaimalai.product_service.domain.Product;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@Builder
@NoArgsConstructor
public class ProductCreateEvent {

    private UUID productId = UUID.randomUUID();
    //    private final List<String> failureMessages;
//    private final ZonedDateTime createdAt;
    private Product product = null;

    public ProductCreateEvent(UUID productId, Product product) {
        this.productId = productId;
        this.product = product;
    }
}
