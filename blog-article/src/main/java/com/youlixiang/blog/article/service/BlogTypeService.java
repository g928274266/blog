package com.youlixiang.blog.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.youlixiang.blog.article.entity.BlogType;
import com.youlixiang.blog.article.vo.BlogTypeVO;
import com.youlixiang.blog.common.exception.CustomException;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 郭非
 * @since 2022-03-16
 */
public interface BlogTypeService extends IService<BlogType> {
    /**
     * 增加文章分类
     *
     * @param blogTypeVO 分类信息
     * @throws CustomException 异常
     */
    void addBlogType(BlogTypeVO blogTypeVO) throws CustomException;

    /**
     * 查询文章分类列表
     *
     * @return 文章分类列表
     */
    List<BlogTypeVO> listBlogType();
}
