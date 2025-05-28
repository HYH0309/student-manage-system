package com.example.hyh.entity.onlinejudge;

import ch.qos.logback.core.status.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JudgeResponse {
    private String stdout;
    private String time;
    private Integer memory;
    private String stderr;
    private String token;
    @JsonProperty("compile_output") // 使用JsonProperty来显式定义JSON属性名与字段名的映射
    private String compileOutput;
    private String message;
    private Status status;
}
