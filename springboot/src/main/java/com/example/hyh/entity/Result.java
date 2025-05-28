package com.example.hyh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result{
    private Boolean code;
    private String msg;

    public static Result success(String msg){
        return new Result(true,msg);
    }
    public static Result error(String msg){
        return new Result(false,msg);
    }
}
