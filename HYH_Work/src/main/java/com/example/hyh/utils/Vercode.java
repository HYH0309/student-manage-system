package com.example.hyh.utils;

import com.google.code.kaptcha.Constants;
import jakarta.servlet.http.HttpSession;

import java.util.Date;

public class Vercode {
    private static final long SESSION_TIMEOUT = 60000;  // 验证码有效时间：60秒
    private static final String KAPTCHA_SESSION_DATE_KEY = "KAPTCHA_SESSION_DATE";

    // 验证验证码的正确性
    public static Boolean verifyCaptcha(String receivedCaptcha, HttpSession session) {
        String storedCaptcha = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        Date storedTime = (Date) session.getAttribute(KAPTCHA_SESSION_DATE_KEY);

        if (receivedCaptcha != null && receivedCaptcha.equalsIgnoreCase(storedCaptcha)) {
            boolean isValid = storedTime != null && (System.currentTimeMillis() - storedTime.getTime()) < SESSION_TIMEOUT;
            // 验证码使用后立即废弃
            session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);
            session.removeAttribute(KAPTCHA_SESSION_DATE_KEY);
            return isValid;
        }

        // 如果验证码不匹配，也删除存储的验证码和时间
        session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);
        session.removeAttribute(KAPTCHA_SESSION_DATE_KEY);
        return false;
    }
}
