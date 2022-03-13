package com.youlixiang.blog.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlixiang.blog.common.constant.LoginErrorEnum;
import com.youlixiang.blog.common.constant.RegisterErrorEnum;
import com.youlixiang.blog.common.util.JwtUtils;
import com.youlixiang.blog.user.entity.BlogUser;
import com.youlixiang.blog.user.exception.CustomException;
import com.youlixiang.blog.user.mapper.BlogUserMapper;
import com.youlixiang.blog.user.service.BlogUserService;
import com.youlixiang.blog.user.util.BcryptEncoderUtils;
import com.youlixiang.blog.user.vo.LoginVO;
import com.youlixiang.blog.user.vo.RegisterVO;
import org.springframework.beans.BeanUtils;
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
    public void register(RegisterVO registerVO) throws CustomException {
        String username = registerVO.getUsername();

        QueryWrapper<BlogUser> blogUserQueryWrapper = new QueryWrapper<>();
        blogUserQueryWrapper.eq("username", username);
        int count = blogUserMapper.selectCount(blogUserQueryWrapper);

        if (count > 0) {
            throw new CustomException(RegisterErrorEnum.DUPLICATE_USERNAME.getCode(),
                    RegisterErrorEnum.DUPLICATE_USERNAME.getMessage());
        }

        String password = registerVO.getPassword();
        String confirmPassword = registerVO.getConfirmPassword();

        if (!password.equals(confirmPassword)) {
            throw new CustomException(RegisterErrorEnum.PASSWORD_NOT_EQUAL.getCode(),
                    RegisterErrorEnum.PASSWORD_NOT_EQUAL.getMessage());
        }

        //将密码MD5盐值加密
        String encodePassword = BcryptEncoderUtils.encode(registerVO.getPassword());
        registerVO.setPassword(encodePassword);

        //将注册信息对拷到blogUser对象中
        BlogUser blogUser = new BlogUser();
        BeanUtils.copyProperties(registerVO, blogUser);

        blogUserMapper.insert(blogUser);
    }

    @Override
    public String loginById(LoginVO loginVO) throws CustomException {
        String username = loginVO.getUsername();

        QueryWrapper<BlogUser> blogUserQueryWrapper = new QueryWrapper<>();
        blogUserQueryWrapper.eq("username", username);

        BlogUser blogUser = blogUserMapper.selectOne(blogUserQueryWrapper);

        if (blogUser == null) {
            throw new CustomException(LoginErrorEnum.USER_NOT_EXIST.getCode()
                    , LoginErrorEnum.USER_NOT_EXIST.getMessage());
        }

        //密码匹配
        String password = loginVO.getPassword();
        String encodedPassword = blogUser.getPassword();

        if (!BcryptEncoderUtils.match(password, encodedPassword)) {
            throw new CustomException(LoginErrorEnum.PASSWORD_NOT_CORRECT.getCode(),
                    LoginErrorEnum.PASSWORD_NOT_CORRECT.getMessage());
        }

        //返回登录token
        return JwtUtils.getJwtToken(username);
    }
}
