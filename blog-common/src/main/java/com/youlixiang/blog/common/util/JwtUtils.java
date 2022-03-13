package com.youlixiang.blog.common.util;

import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Jwt认证工具类
 *
 * @Author 郭非
 * @Date 2022/3/13
 * @Time 13:53
 * @Version 1.0
 */
public class JwtUtils {
    /**
     * 设置token过期时间
     */
    private static final long EXPIRE = 1000 * 60 * 60 * 24;
    /**
     * Jwt密钥
     */
    private static final String APP_SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO";

    private JwtUtils() {

    }

    /**
     * 生成token字符串
     *
     * @param username 用户名
     * @return token
     */
    public static String getJwtToken(String username) {
        JwtBuilder jwtBuilder = Jwts.builder();
        //设置token头信息
        jwtBuilder.setHeaderParam("typ", "JWT");
        jwtBuilder.setHeaderParam("alg", "HS256");

        //设置token主体信息
        jwtBuilder.setSubject("blog-user");
        jwtBuilder.setIssuedAt(new Date());
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + EXPIRE));
        jwtBuilder.claim("username", username);

        //设置token签名hash方式
        jwtBuilder.signWith(SignatureAlgorithm.HS256, APP_SECRET);
        return jwtBuilder.compact();
    }

    /**
     * 判断token是否存在与有效
     *
     * @param jwtToken token
     * @return token是否有效
     */
    public static boolean checkToken(String jwtToken) {
        if (StringUtils.isEmpty(jwtToken)) {
            return false;
        }
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断token是否存在与有效
     *
     * @param request 请求头
     * @return token是否有效
     */
    public static boolean checkToken(HttpServletRequest request) {
        try {
            String jwtToken = request.getHeader("token");
            if (StringUtils.isEmpty(jwtToken)) {
                return false;
            }
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据token获取会员id
     *
     * @param request 请求体
     * @return 会员id
     */
    public static String getUsernameByJwtToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("token");
        if (StringUtils.isEmpty(jwtToken)) {
            return null;
        }
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        return (String) claims.get("username");
    }
}
