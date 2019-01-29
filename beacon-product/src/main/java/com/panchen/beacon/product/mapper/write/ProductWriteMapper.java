package com.panchen.beacon.product.mapper.write;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.panchen.beacon.product.domain.Product;

@Mapper
public interface ProductWriteMapper {
    
    Long addProduct(@Param("product") Product Product);
    
}
