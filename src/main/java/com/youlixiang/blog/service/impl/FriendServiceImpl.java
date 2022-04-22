package com.youlixiang.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlixiang.blog.constant.FriendErrorEnum;
import com.youlixiang.blog.entity.BlogFriend;
import com.youlixiang.blog.exception.CustomException;
import com.youlixiang.blog.mapper.FriendMapper;
import com.youlixiang.blog.service.FriendService;
import com.youlixiang.blog.vo.BlogFriendVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 郭非
 * @since 2022-04-05
 */
@Service
public class FriendServiceImpl extends ServiceImpl<FriendMapper, BlogFriend> implements FriendService {
    @Resource
    private FriendMapper friendMapper;

    @Override
    public void addFriend(BlogFriendVO blogFriendVO) throws CustomException {
        BlogFriend blogFriend = new BlogFriend();

        BeanUtils.copyProperties(blogFriendVO, blogFriend);

        int insert = friendMapper.insert(blogFriend);

        if (insert <= 0) {
            throw new CustomException(FriendErrorEnum.ADD_FRIEND_ERROR.getCode()
                    , FriendErrorEnum.ADD_FRIEND_ERROR.getMessage());
        }
    }

    @Override
    public Map<String, Object> listFriend(Long current, Long limit) {
        IPage<BlogFriend> friendPage = new Page<>(current, limit);

        IPage<BlogFriend> selectPage = friendMapper.selectPage(friendPage, null);

        List<BlogFriend> blogFriendList = selectPage.getRecords();

        List<BlogFriendVO> blogFriendVOList = blogFriendList.stream().map(blogFriend -> {
            BlogFriendVO blogFriendVO = new BlogFriendVO();
            BeanUtils.copyProperties(blogFriend, blogFriendVO);
            return blogFriendVO;
        }).collect(Collectors.toList());

        long total = selectPage.getTotal();
        long size = selectPage.getSize();
        long page = selectPage.getCurrent();

        Map<String, Object> friendMap = new HashMap<>();

        friendMap.put("total", total);
        friendMap.put("size", size);
        friendMap.put("page", page);
        friendMap.put("blogFriendVOList", blogFriendVOList);

        return friendMap;
    }

    @Override
    public void removeFriend(Integer friendId) throws CustomException {
        int delete = friendMapper.deleteById(friendId);

        if (delete <= 0) {
            throw new CustomException(FriendErrorEnum.REMOVE_FRIEND_ERROR.getCode(),
                    FriendErrorEnum.REMOVE_FRIEND_ERROR.getMessage());
        }
    }

    @Override
    public void updateFriend(BlogFriendVO blogFriendVO) throws CustomException {
        BlogFriend blogFriend = new BlogFriend();

        BeanUtils.copyProperties(blogFriendVO, blogFriend);

        int update = friendMapper.updateById(blogFriend);

        if (update <= 0) {
            throw new CustomException(FriendErrorEnum.UPDATE_FRIEND_ERROR.getCode(),
                    FriendErrorEnum.UPDATE_FRIEND_ERROR.getMessage());
        }
    }
}
