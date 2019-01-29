package com.panchen.beacon.common;

import java.io.Serializable;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class BaseEntity implements Serializable {

    @JsonIgnore
    private static final long serialVersionUID = 7189373585237318979L;

    private Long id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
