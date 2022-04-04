package com.youlixiang.blog.util;


import com.youlixiang.blog.constant.UserErrorEnum;
import com.youlixiang.blog.exception.CustomException;

import javax.servlet.http.HttpServletRequest;

/**
 * 校验登录工具类
 *
 * @Author 郭非
 * @Date 2022/3/14
 * @Time 11:53
 * @Version 1.0
 */
public class CheckLoginUtils {
    private CheckLoginUtils() {

    }

    /**
     * 用户是否登录
     *
     * @param request 请求
     * @return 用户名
     * @throws CustomException 异常
     */
    public static String isLogin(HttpServletRequest request) throws CustomException {
        String username = JwtUtils.getUsernameByJwtToken(request);
        if (username == null) {
            throw new CustomException(UserErrorEnum.NOT_LOGIN.getCode()
                    , UserErrorEnum.NOT_LOGIN.getMessage());
        }
        return username;
    }
}
