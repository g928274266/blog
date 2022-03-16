package com.youlixiang.blog.user.handler;

import com.youlixiang.blog.common.constant.UserErrorEnum;
import com.youlixiang.blog.common.util.CommonResult;
import com.youlixiang.blog.user.exception.CustomException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理器
 *
 * @Author 郭非
 * @Date 2022/3/13
 * @Time 10:48
 * @Version 1.0
 */
@RestControllerAdvice(basePackages = {"com.youlixiang.blog.user.controller"})
public class GlobalExceptionHandler {
    /**
     * 参数校验异常处理器
     *
     * @param e 参数校验异常
     * @return 通用返回
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public CommonResult argumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((item) -> {
            errorMap.put(item.getField(), item.getDefaultMessage());
        });
        return CommonResult.error(UserErrorEnum.ARGUMENT_NOT_VALID.getCode()
                , UserErrorEnum.ARGUMENT_NOT_VALID.getMessage() + ",原因是:" + errorMap);
    }

    /**
     * 注册异常处理器
     *
     * @param e 注册异常
     * @return 通用返回
     */
    @ExceptionHandler(value = {CustomException.class})
    public CommonResult registerExceptionHandler(CustomException e) {
        return CommonResult.error(e.getCode(), e.getMessage());
    }
}
