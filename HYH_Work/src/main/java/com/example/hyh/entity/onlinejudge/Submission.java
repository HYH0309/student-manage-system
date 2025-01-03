package com.example.hyh.entity.onlinejudge;

import lombok.Data;

@Data

public class Submission {
    private int tid;//题目id
    private String code; // 提交的代码
    private int languageId; // 编程语言 ID
    private String input; // 输入
    private String expectedOutput; // 预期输出
    private int cpuTimeLimit; // CPU 时间限制
    private int memoryLimit; // 内存限制
}
