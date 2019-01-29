package com.panchen.beacon.product.domain;

import com.panchen.beacon.common.BaseEntity;
import lombok.Data;

@Data
public class Product extends BaseEntity {

    private String introduce;

    private String author;

    private String gitUrl;

    private Integer type;
}
