package com.example.hyh.entity.login;

import lombok.Data;

@Data
public class Login {
    private String username;
    private String password;
    private String captcha;  // Changed to proper camel case.
    private String role;
}
