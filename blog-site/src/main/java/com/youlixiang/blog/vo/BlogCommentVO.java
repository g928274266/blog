package com.youlixiang.blog.vo;

import lombok.Data;

/**
 * 文章评论Vo
 *
 * @Author 郭非
 * @Date 2022/3/16
 * @Time 22:44
 * @Version 1.0
 */
@Data
public class BlogCommentVO {
    /**
     * 文章编号
     */
    private Integer articleId;
    /**
     * 评论内容
     */
    private String context;
    /**
     * 用户编号
     */
    private String username;
}
