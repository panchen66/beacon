package com.panchen.beacon.blog.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.panchen.beacon.common.BaseEntity;

import lombok.Data;

@Data
@Document(collection = "blog")
public class Blog extends BaseEntity {

    @Id
    private ObjectId databaseId;

    private String label;

    private String content;

    private String title;

    private String author;

    private Long star;
}
