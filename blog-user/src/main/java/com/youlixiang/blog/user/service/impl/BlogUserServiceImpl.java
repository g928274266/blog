package com.youlixiang.blog.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlixiang.blog.common.constant.UserErrorEnum;
import com.youlixiang.blog.common.exception.CustomException;
import com.youlixiang.blog.common.util.JwtUtils;
import com.youlixiang.blog.user.entity.BlogUser;
import com.youlixiang.blog.user.mapper.BlogUserMapper;
import com.youlixiang.blog.user.service.BlogUserService;
import com.youlixiang.blog.user.util.BcryptEncoderUtils;
import com.youlixiang.blog.user.vo.BlogUserVO;
import com.youlixiang.blog.user.vo.LoginVO;
import com.youlixiang.blog.user.vo.RegisterVO;
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
            throw new CustomException(UserErrorEnum.DUPLICATE_USERNAME.getCode(),
                    UserErrorEnum.DUPLICATE_USERNAME.getMessage());
        }

        String password = registerVO.getPassword();
        String confirmPassword = registerVO.getConfirmPassword();

        if (!password.equals(confirmPassword)) {
            throw new CustomException(UserErrorEnum.PASSWORD_NOT_EQUAL.getCode(),
                    UserErrorEnum.PASSWORD_NOT_EQUAL.getMessage());
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
            throw new CustomException(UserErrorEnum.USER_NOT_EXIST.getCode()
                    , UserErrorEnum.USER_NOT_EXIST.getMessage());
        }

        //密码匹配
        String password = loginVO.getPassword();
        String encodedPassword = blogUser.getPassword();

        if (!BcryptEncoderUtils.match(password, encodedPassword)) {
            throw new CustomException(UserErrorEnum.PASSWORD_NOT_CORRECT.getCode(),
                    UserErrorEnum.PASSWORD_NOT_CORRECT.getMessage());
        }

        //返回登录token
        return JwtUtils.getJwtToken(username);
    }

    @Override
    public BlogUserVO getInfo(String username) throws CustomException {
        BlogUser blogUser = getBlogUserByUsername(username);

        BlogUserVO userVo = new BlogUserVO();

        BeanUtils.copyProperties(blogUser, userVo);

        return userVo;
    }

    @Override
    public void updateAvatar(String username, String url) throws CustomException {
        BlogUser blogUser = getBlogUserByUsername(username);

        blogUser.setAvatarUrl(url);

        blogUserMapper.updateById(blogUser);
    }

    @Override
    public void uploadInfo(String username, BlogUserVO userVO) {
        String voName = userVO.getUsername();

        if (!username.equals(voName)) {
            return;
        }

        BlogUser blogUser = new BlogUser();

        BeanUtils.copyProperties(userVO, blogUser);

        blogUserMapper.updateById(blogUser);
    }

    @Override
    public Map<String, Object> listUser(Long current, Long limit) {
        IPage<BlogUser> blogUserPage = new Page<>(current, limit);

        IPage<BlogUser> selectPage = blogUserMapper.selectPage(blogUserPage, null);

        Map<String, Object> userMap = new HashMap<>();

        List<BlogUser> blogUsers = selectPage.getRecords();
        long page = selectPage.getCurrent();
        long size = selectPage.getSize();
        long total = selectPage.getTotal();

        List<BlogUserVO> blogUserVOList = blogUsers.stream().map(blogUser -> {
            BlogUserVO blogUserVO = new BlogUserVO();
            BeanUtils.copyProperties(blogUser, blogUserVO);
            return blogUserVO;
        }).collect(Collectors.toList());

        userMap.put("blogUserVOList", blogUserVOList);
        userMap.put("page", page);
        userMap.put("size", size);
        userMap.put("total", total);

        return userMap;
    }

    @Override
    public void removeUser(String username) throws CustomException {
        QueryWrapper<BlogUser> blogUserQueryWrapper = new QueryWrapper<>();
        blogUserQueryWrapper.eq("username", username);

        int delete = blogUserMapper.delete(blogUserQueryWrapper);

        if (delete == 1) {
            return;
        }

        throw new CustomException(UserErrorEnum.USER_NOT_EXIST.getCode(),
                UserErrorEnum.USER_NOT_EXIST.getMessage());
    }

    private BlogUser getBlogUserByUsername(String username) throws CustomException {
        QueryWrapper<BlogUser> blogUserQueryWrapper = new QueryWrapper<>();
        blogUserQueryWrapper.eq("username", username);

        BlogUser blogUser = blogUserMapper.selectOne(blogUserQueryWrapper);

        if (blogUser == null) {
            throw new CustomException(UserErrorEnum.NOT_SUCH_USER.getCode(),
                    UserErrorEnum.NOT_SUCH_USER.getMessage());
        }
        return blogUser;
    }
}
