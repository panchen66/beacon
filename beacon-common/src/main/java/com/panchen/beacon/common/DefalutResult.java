package com.panchen.beacon.common;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DefalutResult implements Serializable {

    private static final long serialVersionUID = 6016192176818353759L;

    private String message;

    private boolean result;

    private Object data;
}
