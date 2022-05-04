package com.youlixiang.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlixiang.blog.constant.ArticleErrorEnum;
import com.youlixiang.blog.entity.BlogArticle;
import com.youlixiang.blog.entity.BlogArticleContent;
import com.youlixiang.blog.entity.BlogType;
import com.youlixiang.blog.exception.CustomException;
import com.youlixiang.blog.mapper.BlogArticleContentMapper;
import com.youlixiang.blog.mapper.BlogArticleMapper;
import com.youlixiang.blog.mapper.BlogTypeMapper;
import com.youlixiang.blog.service.BlogArticleService;
import com.youlixiang.blog.vo.BlogArticlePublishVO;
import com.youlixiang.blog.vo.BlogArticleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
 * @since 2022-03-16
 */
@Service
public class BlogArticleServiceImpl extends ServiceImpl<BlogArticleMapper, BlogArticle> implements BlogArticleService {
    @Resource
    private BlogArticleMapper blogArticleMapper;
    @Resource
    private BlogArticleContentMapper blogArticleContentMapper;
    @Resource
    private BlogTypeMapper blogTypeMapper;

    @Override
    public Map<String, Object> listArticle(Long current, Long limit, BlogArticleVO blogArticleVO) {
        long offset = (limit * current) - limit;
        List<BlogArticle> articleList = blogArticleMapper.listArticle(offset, limit, blogArticleVO);

        Map<String, Object> articleMap = new HashMap<>();

        articleMap.put("page", current);
        articleMap.put("size", limit);
        List<BlogArticleVO> blogArticleVOList = null;

        if (articleList.size() > 0) {
            blogArticleVOList = articleList.stream().map((article) -> {
                BlogArticleVO vo = new BlogArticleVO();
                BeanUtils.copyProperties(article, vo);
                vo.setCreateTime(article.getGmtCreated());
                vo.setModifiedTime(article.getGmtModified());
                BlogType blogType = blogTypeMapper.selectById(article.getTypeId());
                vo.setArticleType(blogType.getTypeName());
                return vo;
            }).collect(Collectors.toList());
        }

        Integer total = blogArticleMapper.selectCount(null);

        articleMap.put("blogArticleVOList", blogArticleVOList);
        articleMap.put("total", total);

        return articleMap;
    }

    @Transactional(rollbackFor = CustomException.class)
    @Override
    public void publishArticle(BlogArticlePublishVO publishVO) throws CustomException {
        BlogArticle blogArticle = new BlogArticle();
        BeanUtils.copyProperties(publishVO, blogArticle);

        int insert = blogArticleMapper.insert(blogArticle);

        if (insert <= 0) {
            throw new CustomException(ArticleErrorEnum.PUBLISH_ARTICLE_ERROR.getCode(),
                    ArticleErrorEnum.PUBLISH_ARTICLE_ERROR.getMessage());
        }

        BlogArticleContent blogArticleContent = new BlogArticleContent();
        blogArticleContent.setContent(publishVO.getContent());
        blogArticleContent.setArticleId(blogArticle.getArticleId());
        System.out.println(blogArticle.getArticleId());

        int contentInsert = blogArticleContentMapper.insert(blogArticleContent);

        if (contentInsert <= 0) {
            throw new CustomException(ArticleErrorEnum.PUBLISH_ARTICLE_ERROR.getCode(),
                    ArticleErrorEnum.PUBLISH_ARTICLE_ERROR.getMessage());
        }
    }

    @Transactional(rollbackFor = CustomException.class)
    @Override
    public void removeArticle(Integer articleId) throws CustomException {
        int delete = blogArticleMapper.deleteById(articleId);

        if (delete <= 0) {
            throw new CustomException(ArticleErrorEnum.REMOVE_ARTICLE_ERROR.getCode(),
                    ArticleErrorEnum.REMOVE_ARTICLE_ERROR.getMessage());
        }

        int deleteContent = blogArticleContentMapper.deleteById(articleId);

        if (deleteContent <= 0) {
            throw new CustomException(ArticleErrorEnum.REMOVE_ARTICLE_CONTENT_ERROR.getCode(),
                    ArticleErrorEnum.REMOVE_ARTICLE_CONTENT_ERROR.getMessage());
        }
    }

    @Transactional(rollbackFor = CustomException.class)
    @Override
    public void updateArticle(BlogArticlePublishVO publishVO) throws CustomException {
        BlogArticle blogArticle = new BlogArticle();
        BeanUtils.copyProperties(publishVO, blogArticle);

        int update = blogArticleMapper.updateById(blogArticle);

        if (update <= 0) {
            throw new CustomException(ArticleErrorEnum.UPDATE_ARTICLE_ERROR.getCode(),
                    ArticleErrorEnum.UPDATE_ARTICLE_ERROR.getMessage());
        }

        BlogArticleContent blogArticleContent = new BlogArticleContent();
        BeanUtils.copyProperties(publishVO, blogArticleContent);

        int updateContent = blogArticleContentMapper.updateById(blogArticleContent);

        if (updateContent <= 0) {
            throw new CustomException(ArticleErrorEnum.UPDATE_ARTICLE_CONTENT_ERROR.getCode(),
                    ArticleErrorEnum.UPDATE_ARTICLE_CONTENT_ERROR.getMessage());
        }
    }
}
