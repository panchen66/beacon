package com.panchen.beacon.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panchen.beacon.product.domain.Product;
import com.panchen.beacon.product.mapper.read.ProductReadMapper;
import com.panchen.beacon.product.mapper.write.ProductWriteMapper;
import com.panchen.beacon.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductReadMapper productReadMapper;

    @Autowired
    ProductWriteMapper productWriteMapper;

    @Override
    public List<Product> getProductList(Product product) {
        return productReadMapper.getProductList(product);
    }

    @Override
    public Long addProduct(Product product) {
        return productWriteMapper.addProduct(product);
    }



}
