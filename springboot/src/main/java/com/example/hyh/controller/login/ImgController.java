package com.example.hyh.controller.login;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;


@Controller
@RequestMapping("/api")
@CrossOrigin(originPatterns = "*", allowCredentials = "true")
public class ImgController {

    private static final String KAPTCHA_SESSION_DATE_KEY = "KAPTCHA_SESSION_DATE";

    private static final Logger logger = LoggerFactory.getLogger(ImgController.class);
    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @GetMapping("/code")
    public void generateCaptcha(HttpSession session, HttpServletResponse response) {
        setNoCacheHeaders(response);
        response.setContentType("image/jpeg");

        try {
            String captchaText = defaultKaptcha.createText();
            logger.info("生成的验证码文本: {}", captchaText);
            session.setAttribute(Constants.KAPTCHA_SESSION_KEY, captchaText);
            session.setAttribute(KAPTCHA_SESSION_DATE_KEY, new Date());  // 保存生成时间

            BufferedImage captchaImage = defaultKaptcha.createImage(captchaText);
            writeCaptchaImage(response, captchaImage);
        } catch (Exception e) {
            logger.error("生成或写入验证码错误", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    private void setNoCacheHeaders(HttpServletResponse response) {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
    }

    private void writeCaptchaImage(HttpServletResponse response, BufferedImage bi) throws IOException {
        try (jakarta.servlet.ServletOutputStream out = response.getOutputStream()) {
            ImageIO.write(bi, "jpg", out);
            out.flush();
        }
    }
}
