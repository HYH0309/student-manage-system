package com.example.hyh.service.manager;

import com.example.hyh.entity.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticles();
    int addArticle(Article article);
    int updateArticle(Article article,int id);
    int deleteArticle(int id);
    Article getArticleById(int id);

}
