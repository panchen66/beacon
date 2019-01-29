package com.panchen.beacon.product.service;


import java.util.List;
import com.panchen.beacon.product.domain.Product;

public interface ProductService {
    
    List<Product> getProductList(Product product);
    
    Long addProduct(Product product);
    
}
