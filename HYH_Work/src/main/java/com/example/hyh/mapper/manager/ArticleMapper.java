package com.example.hyh.mapper.manager;

import com.example.hyh.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Select("SELECT id, title, people, date, url FROM article")
    List<Article> findAllArticles();

    @Select("SELECT id, title, people, date, url FROM article WHERE id = #{id}")
    Article findArticleById(int id);

    @Insert("INSERT INTO article (title, people, date, url) VALUES (#{title}, #{people}, #{date}, #{url})")
    int createArticle(Article article);

    @Update("UPDATE article SET title = #{title}, people = #{people}, date = #{date}, url = #{url} WHERE id = #{id}")
    int updateArticle(Article article,int id);

    @Delete("DELETE FROM article WHERE id = #{id}")
    int deleteArticle(int id);
}
