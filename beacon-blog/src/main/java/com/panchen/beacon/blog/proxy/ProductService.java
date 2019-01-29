package com.panchen.beacon.blog.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.panchen.beacon.common.DefalutResult;

@FeignClient("product")
public interface ProductService {
    
    @PostMapping(value = "/product/{id}")
    public DefalutResult getProduct(@PathVariable(value="id") Long id) ;
    
}
