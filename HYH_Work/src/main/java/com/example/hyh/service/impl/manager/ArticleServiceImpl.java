package com.example.hyh.service.impl.manager;

import com.example.hyh.entity.Article;
import com.example.hyh.mapper.manager.ArticleMapper;
import com.example.hyh.service.manager.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> getAllArticles() {
        return articleMapper.findAllArticles();
    }


    @Override
    public int addArticle(Article article) {
        return articleMapper.createArticle(article);
    }

    public int updateArticle(Article article,int id) {
        return articleMapper.updateArticle(article,id);
    }

    @Override
    public int deleteArticle(int id) {
        return articleMapper.deleteArticle(id);
    }

    @Override
    public Article getArticleById(int id) {
        return articleMapper.findArticleById(id);
    }
}
