package com.youlixiang.blog.user.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 郭非
 * @Date 2022/3/12
 * @Time 22:24
 * @Version 1.0
 */
@Component
public class MyBatisPlusMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        String formatTime = formatTime();
        setFieldValByName("logicDeleted", 0, metaObject);
        setFieldValByName("gmtCreated", formatTime, metaObject);
        setFieldValByName("gmtModified", formatTime, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        String formatTime = formatTime();
        setFieldValByName("gmtModified", formatTime, metaObject);
    }

    /**
     * 格式化当前时间
     *
     * @return 格式化后的时间
     */
    private String formatTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }
}
