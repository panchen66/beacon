package com.panchen.beacon.common;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.Getter;

@Getter
public class PageQuery {

    private Pageable pageable;

    private Sort sort;

    public PageQuery(int page, int size, Direction direction, String... properties) {
        this.pageable = new PageRequest(page, size);
        if (null != direction) {
            this.sort = new Sort(direction, properties);
        }
    }
}
