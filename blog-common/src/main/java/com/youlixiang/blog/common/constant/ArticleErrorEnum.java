package com.youlixiang.blog.common.constant;

/**
 * @Author 郭非
 * @Date 2022/3/17
 * @Time 22:43
 * @Version 1.0
 */
public enum ArticleErrorEnum {
    /**
     * 增加文章分类失败
     */
    ADD_ARTICLE_TYPE_ERROR(20010, "增加文章分类失败");


    private final int code;

    private final String message;

    ArticleErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
