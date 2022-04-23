package com.youlixiang.blog.vo;

import lombok.Data;

/**
 * 文章发布VO
 *
 * @Author 郭非
 * @Date 2022/4/23
 * @Time 13:56
 * @Version 1.0
 */
@Data
public class BlogArticlePublishVO {
    /**
     * 文章编号
     */
    private Integer articleId;
    /**
     * 类型编号
     */
    private Integer typeId;
    /**
     * 文章标题
     */
    private String articleTitle;
    /**
     * 作者
     */
    private String author;
    /**
     * 浏览数量
     */
    private Long viewCount;
    /**
     * 文章内容
     */
    private String content;
}
