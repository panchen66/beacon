package com.panchen.beacon.blog.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.panchen.beacon.blog.service.BlogService;
import com.panchen.beacon.common.DefalutResult;
import com.panchen.beacon.common.PageQuery;
import com.panchen.beacon.common.constant.CommonConstant;
import com.panchen.beacon.blog.proxy.ProductService;

@RestController
public class BlogController {

    @Autowired
    private BlogService BlogService;
    
    @Autowired
    private ProductService ProductService;
    
    @GetMapping(value = "/topic/{page}")
    public DefalutResult getBlogList(@PathVariable int page) {
        PageQuery pageQuery = new PageQuery(page, CommonConstant.Public.PAGESIZE, null, null);
        return new DefalutResult("获取博客列表成功",Boolean.TRUE,BlogService.getBlogList(pageQuery));
    }

    @GetMapping(value = "/blog/{id}")
    public DefalutResult getBlogList(@PathVariable Long id) {
        ProductService.getProduct(id);
        return new DefalutResult("获取博客信息成功",Boolean.TRUE,BlogService.getBlogById(id));
    }
}
