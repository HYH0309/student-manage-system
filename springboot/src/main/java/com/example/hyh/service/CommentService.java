package com.example.hyh.service;

import com.example.hyh.mapper.CommentMapper;
import com.example.hyh.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService {

    private final CommentMapper commentMapper;

    @Autowired
    public CommentService(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }
    // 获取所有评论
    public List<Comment> getAllComments() {
        return commentMapper.findAllComments();
    }

    // 添加新评论
    public boolean addComment(Comment comment) {
        // 这里可以添加任何必要的业务逻辑，例如验证评论的内容是否合适
        if (comment == null || comment.getContent() == null || comment.getContent().trim().isEmpty()) {
            return false; // 或者抛出一个适当的异常，取决于你的错误处理策略
        }
        // 尝试插入评论到数据库
        return commentMapper.insertComment(comment) == 1;
    }

}
