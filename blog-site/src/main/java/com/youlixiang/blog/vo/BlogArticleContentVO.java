package com.youlixiang.blog.vo;

import lombok.Data;

/**
 * 文章内容VO
 *
 * @Author 郭非
 * @Date 2022/4/24
 * @Time 13:15
 * @Version 1.0
 */
@Data
public class BlogArticleContentVO {
    /**
     * 文章编号
     */
    private Integer articleId;
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
    /**
     * 更新时间
     */
    private String modifiedTime;
}
