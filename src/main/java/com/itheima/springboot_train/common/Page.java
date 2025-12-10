package com.itheima.springboot_train.common;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {
    private Long total;        // 总记录数
    private List<T> rows;      // 当前页记录列表
    private Integer pageNum;   // 当前页码
    private Integer pageSize;  // 每页大小
    private Integer pages;     // 总页数
}
