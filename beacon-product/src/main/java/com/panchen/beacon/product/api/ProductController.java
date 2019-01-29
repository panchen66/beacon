package com.panchen.beacon.product.api;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.panchen.beacon.common.DefalutResult;
import com.panchen.beacon.product.domain.Product;
import com.panchen.beacon.product.service.ProductService;

@RestController
public class ProductController {
    
    @Autowired
    ProductService productService;
    
    @GetMapping(value = "/products")
    public DefalutResult getProductList(Product product) {
        return new DefalutResult("获取产品列表成功",Boolean.TRUE,productService.getProductList(product));
    }

    @PostMapping(value = "/product")
    public DefalutResult addProduct(Product product) {
        product.setAuthor("test2");
        product.setGitUrl("test2");
        product.setType(2);
        product.setCreateTime(LocalDateTime.now());
        product.setUpdateTime(LocalDateTime.now());
        return new DefalutResult("新增产品成功",Boolean.TRUE,productService.addProduct(product));
    }
    
    @GetMapping(value = "/product/{id}")
    public DefalutResult getProduct(@PathVariable(value="id") Long id) {
        return new DefalutResult("获取产品信息成功",Boolean.TRUE,null);
    }
}
