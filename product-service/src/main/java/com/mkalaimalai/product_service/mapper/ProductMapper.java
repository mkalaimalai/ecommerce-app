package com.mkalaimalai.product_service.mapper;

import com.mkalaimalai.product_service.domain.Discount;
import com.mkalaimalai.product_service.domain.Product;
import com.mkalaimalai.product_service.domain.ProductCategory;
import com.mkalaimalai.product_service.domain.ProductInventory;
import com.mkalaimalai.product_service.dto.DiscountDTO;
import com.mkalaimalai.product_service.dto.ProductCategoryDTO;
import com.mkalaimalai.product_service.dto.ProductDTO;
import com.mkalaimalai.product_service.dto.ProductInventoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source="id", target="id")
    public ProductDTO toProductDTO(Product entity) ;

    @Mapping(source="id", target="id")
    public Product toProductEntity(ProductDTO dto) ;

    @Mapping(source="id", target="id")
    public ProductCategoryDTO toProductCategoryDTO(ProductCategory entity) ;

    @Mapping(source="id", target="id")
    public ProductCategory toProductCategoryEntity(ProductCategoryDTO dto) ;

    @Mapping(source="id", target="id")
    public DiscountDTO toDiscountDTO(Discount entity) ;

    @Mapping(source="id", target="id")
    public Discount toDiscountEntity(DiscountDTO dto) ;

    @Mapping(source="id", target="id")
    public ProductInventory toProductInventoryEntity(ProductInventoryDTO dto) ;

    @Mapping(source="id", target="id")
    public ProductInventoryDTO toProductInventoryDTO(ProductInventory entity) ;




}
