package com.youlixiang.blog.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.youlixiang.blog.article.entity.BlogArticle;
import com.youlixiang.blog.article.vo.BlogArticleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 郭非
 * @since 2022-03-16
 */
public interface BlogArticleMapper extends BaseMapper<BlogArticle> {
    /**
     * 条件查询文章列表
     *
     * @param current       当前页码
     * @param limit         页面大小
     * @param blogArticleVO 条件信息
     * @return 文章列表
     */
    List<BlogArticleVO> listArticle(@Param("current") Long current, @Param("limit") Long limit,
                                    @Param("blogArticleVO") BlogArticleVO blogArticleVO);
}
