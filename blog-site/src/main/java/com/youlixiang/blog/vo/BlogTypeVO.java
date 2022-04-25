package com.youlixiang.blog.vo;

import lombok.Data;

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
     * 类型编号
     */
    private Integer typeId;
    /**
     * 类型名称
     */
    private String typeName;
}
