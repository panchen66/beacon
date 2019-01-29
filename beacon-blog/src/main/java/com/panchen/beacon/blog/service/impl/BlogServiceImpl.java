package com.panchen.beacon.blog.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.panchen.beacon.blog.domain.Blog;
import com.panchen.beacon.blog.service.BlogService;
import com.panchen.beacon.common.PageQuery;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private MongoTemplate MongoTemplate;
    
    @Override
    public Blog getBlogById(Long id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id.toString()));
        return (Blog) MongoTemplate.findOne(query, Blog.class);
    }

    @Override
    public List<Blog> getBlogList(PageQuery pageQuery) {
        Query query = new Query();
        query.with(pageQuery.getPageable()).with(pageQuery.getSort());
        return MongoTemplate.find(query, Blog.class);
    }


}
