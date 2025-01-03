package com.example.hyh.controller;

import com.example.hyh.entity.Comment;
import com.example.hyh.entity.Result;
import com.example.hyh.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CommentsController {
    @Autowired
    private CommentMapper commentMapper;

    @GetMapping("/getComments")
    public List<Comment> getComments() {
        return commentMapper.findAllComments();
    }

    @PostMapping("/addComment")
    public Result addComment(@RequestParam String userName, @RequestParam String content) {
        Comment comment = new Comment();
        comment.setUserName(userName);
        comment.setContent(content);
        comment.setCreatedAt(new Date());  // 设置当前时间为评论的创建时间

        boolean inserted = commentMapper.insertComment(comment) == 1;
        if (inserted) {
            return new Result(true, "Comment Added Successfully");
        } else {
            return new Result(false, "Failed to Add Comment");
        }
    }
}
