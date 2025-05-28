package com.example.hyh.mapper;

import com.example.hyh.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import java.util.List;

@Mapper
public interface CommentMapper {

    // 向数据库中插入一条新的评论
    @Insert("INSERT INTO comments (user_name, content, created_at) VALUES (#{userName}, #{content}, #{createdAt})")
    int insertComment(Comment comment);

    // 从数据库中检索所有评论
    @Select("SELECT id, user_name, content, created_at FROM comments")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "content", column = "content"),
            @Result(property = "createdAt", column = "created_at")
    })
    List<Comment> findAllComments();
}
