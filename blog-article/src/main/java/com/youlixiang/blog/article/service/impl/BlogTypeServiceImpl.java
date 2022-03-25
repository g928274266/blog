package com.youlixiang.blog.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlixiang.blog.article.entity.BlogType;
import com.youlixiang.blog.article.mapper.BlogTypeMapper;
import com.youlixiang.blog.article.service.BlogTypeService;
import com.youlixiang.blog.article.vo.BlogTypeVO;
import com.youlixiang.blog.common.constant.ArticleErrorEnum;
import com.youlixiang.blog.common.exception.CustomException;
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
}
