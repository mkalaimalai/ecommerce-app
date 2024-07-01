package com.mkalaimalai.product_service;

import lombok.Data;

import java.util.List;

@Data
public class ProductCategory {

    String categoryName;
    List<CatalotProduct> CatalogProducts;

    public class CatalotProduct{
        String CategoryName;
    }
}
