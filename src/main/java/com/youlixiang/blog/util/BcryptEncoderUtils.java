package com.youlixiang.blog.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 密码加密工具类
 *
 * @Author 郭非
 * @Date 2022/3/13
 * @Time 14:20
 * @Version 1.0
 */
public class BcryptEncoderUtils {
    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    private BcryptEncoderUtils() {

    }

    /**
     * 密码匹配方法
     *
     * @param password        待匹配密码
     * @param encodedPassword 加密密码
     * @return 是否匹配
     */
    public static boolean match(String password, String encodedPassword) {
        return ENCODER.matches(password, encodedPassword);
    }

    /**
     * 盐值加密方法
     *
     * @param password 待加密密码
     * @return 加密后密码
     */
    public static String encode(String password) {
        return ENCODER.encode(password);
    }
}
