package com.youlixiang.blog.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.youlixiang.blog.common.constant.ReturnEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用返回类
 *
 * @Author 郭非
 * @Date 2021/10/10
 * @Time 9:53
 * @Version 1.0
 */
public class CommonResult extends HashMap<String, Object> {
    /**
     * 成功方法
     */
    public CommonResult() {
        put("code", ReturnEnum.COMMON_SUCCESS.getCode());
        put("message", ReturnEnum.COMMON_SUCCESS.getMessage());
    }

    /**
     * 传入map类型的成功方法
     *
     * @param map map类型数据
     * @return 通用返回
     */
    public static CommonResult success(Map<String, Object> map) {
        CommonResult commonResult = new CommonResult();
        commonResult.putAll(map);
        return commonResult;
    }

    /**
     * 传入操作信息的成功方法
     *
     * @param message 成功信息
     * @return 通用返回
     */
    public static CommonResult success(String message) {
        CommonResult commonResult = new CommonResult();
        commonResult.put("code", ReturnEnum.COMMON_SUCCESS.getCode());
        commonResult.put("message", message);
        return commonResult;
    }

    /**
     * 链表式成功方法
     *
     * @return 通用返回
     */
    public static CommonResult success() {
        return new CommonResult();
    }

    /**
     * 通用失败方法
     *
     * @return 通用返回
     */
    public static CommonResult error() {
        CommonResult commonResult = new CommonResult();
        commonResult.put("code", ReturnEnum.COMMON_ERROR.getCode());
        commonResult.put("message", ReturnEnum.COMMON_ERROR.getMessage());
        return commonResult;
    }

    /**
     * 传入状态码以及操作信息的失败方法
     *
     * @param code    失败状态码
     * @param message 失败信息
     * @return 通用返回
     */
    public static CommonResult error(int code, String message) {
        CommonResult commonResult = new CommonResult();
        commonResult.put("code", code);
        commonResult.put("message", message);
        return commonResult;
    }

    /**
     * 传入操作信息的失败方法
     *
     * @param message 失败信息
     * @return 通用返回
     */
    public static CommonResult error(String message) {
        CommonResult commonResult = new CommonResult();
        commonResult.put("code", ReturnEnum.COMMON_ERROR.getCode());
        commonResult.put("message", message);
        return commonResult;
    }

    /**
     * 传入返回值的方法
     *
     * @param key   key
     * @param value value
     * @return 通用返回
     */
    @Override
    public CommonResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * 进行数据的反序列化
     *
     * @param tTypeReference fastjson 类型转换器
     * @param <T>            泛型
     * @return 泛型类型
     */
    public <T> T getData(TypeReference<T> tTypeReference) {
        Object data = get("data");
        String s = JSON.toJSONString(data);
        return JSON.parseObject(s, tTypeReference);
    }

    /**
     * 设置数据准备序列化
     *
     * @param data 传输数据
     * @return 通用返回
     */
    public CommonResult setData(Object data) {
        put("data", data);
        return this;
    }

    /**
     * 获取返回值方法
     *
     * @return 状态码
     */
    public Integer getCode() {
        return (Integer) get("code");
    }
}
