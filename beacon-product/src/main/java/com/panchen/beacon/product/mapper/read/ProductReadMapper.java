package com.panchen.beacon.product.mapper.read;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.panchen.beacon.product.domain.Product;

@Mapper
public interface ProductReadMapper {
    
    List<Product> getProductList(@Param("product") Product Product);
    
}
