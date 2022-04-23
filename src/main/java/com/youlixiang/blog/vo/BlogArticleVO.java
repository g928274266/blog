package com.youlixiang.blog.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.Max;

/**
 * 文章VO
 *
 * @Author 郭非
 * @Date 2022/3/17
 * @Time 13:59
 * @Version 1.0
 */
@Data
public class BlogArticleVO {
    /**
     * 文章编号
     */
    private Integer articleId;
    /**
     * 类型
     */
    @Max(value = 30)
    private String type;
    /**
     * 文章标题
     */
    @Max(value = 30)
    private String articleTitle;
    /**
     * 作者
     */
    @Max(value = 30)
    private String author;
    /**
     * 浏览数量
     */
    private Long viewCount;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTime;
    /**
     * 截止时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String deadline;
    /**
     * 更新时间
     */
    private String modifiedTime;
}
