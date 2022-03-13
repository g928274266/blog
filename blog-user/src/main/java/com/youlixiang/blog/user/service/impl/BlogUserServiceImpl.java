package com.youlixiang.blog.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlixiang.blog.common.constant.RegisterErrorEnum;
import com.youlixiang.blog.user.entity.BlogUser;
import com.youlixiang.blog.user.exception.RegisterException;
import com.youlixiang.blog.user.mapper.BlogUserMapper;
import com.youlixiang.blog.user.service.BlogUserService;
import com.youlixiang.blog.user.vo.RegisterVo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 郭非
 * @since 2022-03-12
 */
@Service
public class BlogUserServiceImpl extends ServiceImpl<BlogUserMapper, BlogUser> implements BlogUserService {
    @Resource
    private BlogUserMapper blogUserMapper;

    @Override
    public void register(RegisterVo registerVo) throws RegisterException {
        String username = registerVo.getUsername();

        QueryWrapper<BlogUser> blogUserQueryWrapper = new QueryWrapper<>();
        blogUserQueryWrapper.eq("username", username);
        int count = blogUserMapper.selectCount(blogUserQueryWrapper);

        if (count > 0) {
            throw new RegisterException(RegisterErrorEnum.DUPLICATE_USERNAME.getCode(),
                    RegisterErrorEnum.DUPLICATE_USERNAME.getMessage());
        }

        String password = registerVo.getPassword();
        String confirmPassword = registerVo.getConfirmPassword();

        if (!password.equals(confirmPassword)) {
            throw new RegisterException(RegisterErrorEnum.PASSWORD_NOT_EQUAL.getCode(),
                    RegisterErrorEnum.PASSWORD_NOT_EQUAL.getMessage());
        }

        //将密码MD5盐值加密
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(registerVo.getPassword());
        registerVo.setPassword(encodePassword);

        //将注册信息对拷到blogUser对象中
        BlogUser blogUser = new BlogUser();
        BeanUtils.copyProperties(registerVo, blogUser);

        blogUserMapper.insert(blogUser);
    }
}
