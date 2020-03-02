package com.xdx97.framework.entitys.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Message<T> implements Serializable {
    private String id;
    private T content;
}