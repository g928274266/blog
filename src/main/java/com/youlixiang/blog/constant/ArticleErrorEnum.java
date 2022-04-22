package com.youlixiang.blog.constant;

/**
 * 文章错误枚举类
 *
 * @Author 郭非
 * @Date 2022/3/17
 * @Time 22:43
 * @Version 1.0
 */
public enum ArticleErrorEnum {
    /**
     * 增加文章分类失败
     */
    ADD_ARTICLE_TYPE_ERROR(20010, "增加文章分类失败"),
    /**
     * 修改文章分类失败
     */
    UPDATE_ARTICLE_TYPE_ERROR(20011, "修改文章分类失败"),
    /**
     * 删除文章分类失败
     */
    REMOVE_ARTICLE_TYPE_ERROR(20012, "删除文章分类失败"),
    /**
     * 文章分类下还存在文章
     */
    EXIST_ARTICLE_ERROR(20013, "文章分类下还存在文章");


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
