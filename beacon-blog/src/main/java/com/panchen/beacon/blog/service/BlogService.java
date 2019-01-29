package com.panchen.beacon.blog.service;

import java.util.List;
import com.panchen.beacon.blog.domain.Blog;
import com.panchen.beacon.common.PageQuery;

public interface BlogService {
    
    public Blog getBlogById(Long id);
    
    public List<Blog> getBlogList(PageQuery pageQuery) ;
}
