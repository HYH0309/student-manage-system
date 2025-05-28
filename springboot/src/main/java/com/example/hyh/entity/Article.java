package com.example.hyh.entity;

import lombok.Data;

@Data
public class Article {
    private int id; // 文章ID
    private String title; // 标题
    private String people; // 作者
    private String date; // 日期
    private String url; // 链接
}
