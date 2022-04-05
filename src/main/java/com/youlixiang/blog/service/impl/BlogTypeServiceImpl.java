package com.youlixiang.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlixiang.blog.constant.ArticleErrorEnum;
import com.youlixiang.blog.entity.BlogArticle;
import com.youlixiang.blog.entity.BlogType;
import com.youlixiang.blog.exception.CustomException;
import com.youlixiang.blog.mapper.BlogArticleMapper;
import com.youlixiang.blog.mapper.BlogTypeMapper;
import com.youlixiang.blog.service.BlogTypeService;
import com.youlixiang.blog.vo.BlogTypeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
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
public class BlogTypeServiceImpl extends ServiceImpl<BlogTypeMapper, BlogType> implements BlogTypeService {
    @Resource
    private BlogTypeMapper blogTypeMapper;
    @Resource
    private BlogArticleMapper blogArticleMapper;

    @Override
    public void addBlogType(BlogTypeVO blogTypeVO) throws CustomException {
        BlogType blogType = new BlogType();

        BeanUtils.copyProperties(blogTypeVO, blogType);

        int insert = blogTypeMapper.insert(blogType);

        if (insert <= 0) {
            throw new CustomException(ArticleErrorEnum.ADD_ARTICLE_TYPE_ERROR.getCode(),
                    ArticleErrorEnum.ADD_ARTICLE_TYPE_ERROR.getMessage());
        }
    }

    @Override
    public List<BlogTypeVO> listBlogType() {
        List<BlogType> blogTypeList = blogTypeMapper.selectList(null);

        return blogTypeList.stream().map(blogType -> {
            BlogTypeVO blogTypeVO = new BlogTypeVO();
            BeanUtils.copyProperties(blogType, blogTypeVO);
            return blogTypeVO;
        }).collect(Collectors.toList());
    }

    @Override
    public void updateBlogType(BlogTypeVO blogTypeVO) throws CustomException {
        BlogType blogType = new BlogType();

        BeanUtils.copyProperties(blogTypeVO, blogType);

        int update = blogTypeMapper.updateById(blogType);

        if (update <= 0) {
            throw new CustomException(ArticleErrorEnum.UPDATE_ARTICLE_TYPE_ERROR.getCode(),
                    ArticleErrorEnum.UPDATE_ARTICLE_TYPE_ERROR.getMessage());
        }
    }

    @Override
    public void removeBlogType(Integer typeId) throws CustomException {
        QueryWrapper<BlogArticle> blogArticleQueryWrapper = new QueryWrapper<>();

        blogArticleQueryWrapper.eq("type_id", typeId);

        Integer count = blogArticleMapper.selectCount(blogArticleQueryWrapper);

        if (count > 0) {
            throw new CustomException(ArticleErrorEnum.EXIST_ARTICLE_ERROR.getCode(),
                    ArticleErrorEnum.EXIST_ARTICLE_ERROR.getMessage());
        }

        int delete = blogTypeMapper.deleteById(typeId);

        if (delete <= 0) {
            throw new CustomException(ArticleErrorEnum.REMOVE_ARTICLE_TYPE_ERROR.getCode()
                    , ArticleErrorEnum.REMOVE_ARTICLE_TYPE_ERROR.getMessage());
        }
    }
}
