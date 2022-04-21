package com.youlixiang.blog.vo;

import lombok.Data;

/**
 * 友链VO
 *
 * @Author 郭非
 * @Date 2022/4/7
 * @Time 14:02
 * @Version 1.0
 */
@Data
public class BlogFriendVO {
    /**
     * 友链编号
     */
    private Integer friendId;
    /**
     * 友链名称
     */
    private String friendName;
    /**
     * 友链链接
     */
    private String friendUrl;
    /**
     * 友链描述
     */
    private String friendDescribe;
}
