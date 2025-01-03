package com.example.hyh.controller.manager;


import com.example.hyh.entity.Article;
import com.example.hyh.entity.Result;
import com.example.hyh.service.manager.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllArticles() {
        List<Article>table= articleService.getAllArticles();
        Map<String, Object> response = new HashMap<>();
        response.put("code", true);
        response.put("data", table);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public Result createArticle(@RequestBody Article article) {
        int result = articleService.addArticle(article);
        if(result>0){
            return Result.success("添加成功");
        }
        else {
            return Result.error("添加失败");
        }
    }

    @PutMapping("/{id}")
    public Result updateArticle(@PathVariable int id, @RequestBody Article article) {
        int result = articleService.updateArticle(article,id);
        if(result>0){
            return Result.success("更新成功");
        }
        else {
            return Result.error("更新失败");
        }
    }

    @DeleteMapping("/{id}")
    public Result deleteArticle(@PathVariable int id) {
        int res = articleService.deleteArticle(id);
        if(res>0){
            return Result.success("删除成功");
        }
        else {
            return Result.error("删除失败");
        }
    }
}
