package com.youlixiang.blog.article.vo;

import com.youlixiang.blog.common.validate.InsertGroup;
import lombok.Data;

import javax.validation.constraints.Max;

/**
 * 文章分类VO
 *
 * @Author 郭非
 * @Date 2022/3/17
 * @Time 22:39
 * @Version 1.0
 */
@Data
public class BlogTypeVO {
    /**
     * 类型名称
     */
    @Max(value = 30, message = "类型最多三十个字符", groups = {InsertGroup.class})
    private String typeName;
}
