package com.youlixiang.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.youlixiang.blog.entity.BlogFriend;
import com.youlixiang.blog.exception.CustomException;
import com.youlixiang.blog.vo.BlogFriendVO;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 郭非
 * @since 2022-04-05
 */
public interface FriendService extends IService<BlogFriend> {
    /**
     * 添加友链
     *
     * @param blogFriendVO 友链信息
     * @throws CustomException 异常
     */
    void addFriend(BlogFriendVO blogFriendVO) throws CustomException;

    /**
     * 友链列表
     *
     * @param current 当前页
     * @param limit   页面大小
     * @return 友链集合
     */
    Map<String, Object> listFriend(Long current, Long limit);

    /**
     * 删除友链
     *
     * @param friendId 友链编号
     * @throws CustomException 异常
     */
    void removeFriend(Integer friendId) throws CustomException;

    /**
     * 更新友链
     *
     * @param blogFriendVO 友链信息
     * @throws CustomException 异常
     */
    void updateFriend(BlogFriendVO blogFriendVO) throws CustomException;
}
