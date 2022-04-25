package com.youlixiang.blog.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.youlixiang.blog.entity.BlogType;
import com.youlixiang.blog.exception.CustomException;
import com.youlixiang.blog.vo.BlogTypeVO;

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

    /**
     * 修改文章分类
     *
     * @param blogTypeVO 分类信息
     * @throws CustomException 异常
     */
    void updateBlogType(BlogTypeVO blogTypeVO) throws CustomException;

    /**
     * 删除文章分类
     *
     * @param typeId 分类编号
     * @throws CustomException 异常
     */
    void removeBlogType(Integer typeId) throws CustomException;

    /**
     * 获取文章分类
     *
     * @param articleId 文章编号
     * @return 文章分类
     */
    String getBlogType(Integer articleId);
}
