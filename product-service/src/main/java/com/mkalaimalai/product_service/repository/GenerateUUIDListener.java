package com.mkalaimalai.product_service.repository;

import com.mkalaimalai.product_service.domain.Discount;
import com.mkalaimalai.product_service.domain.Product;
import com.mkalaimalai.product_service.domain.ProductCategory;
import com.mkalaimalai.product_service.domain.ProductInventory;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GenerateUUIDListener extends AbstractMongoEventListener<Product> {

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Product> event) {
        Product product = event.getSource();
        if (product !=null && product.getId() == null) {
            product.setId(UUID.randomUUID());
        }
    }

//
//    @Override
//    public void onBeforeConvert(BeforeConvertEvent<ProductCategory> event) {
//        ProductCategory productCategory = event.getSource();
//        if (productCategory !=null && productCategory.getId() == null) {
//            productCategory.setId(UUID.randomUUID());
//        }
//    }
//
//
//
//    @Override
//    public void onBeforeConvert(BeforeConvertEvent<Discount> event) {
//        Discount discount = event.getSource();
//        if (discount !=null && discount.getId() == null) {
//            discount.setId(UUID.randomUUID());
//        }
//    }
//
//
//    @Override
//    public void onBeforeConvert(BeforeConvertEvent<ProductInventory> event) {
//        ProductInventory inventory = event.getSource();
//        if (inventory !=null && inventory.getId() == null) {
//            inventory.setId(UUID.randomUUID());
//        }
//    }

}
