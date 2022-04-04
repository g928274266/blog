package com.youlixiang.blog.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * MyBatisPlus数据填充处理器
 *
 * @Author 郭非
 * @Date 2022/3/25
 * @Time 17:40
 * @Version 1.0
 */
@Component
public class MyBatisPlusMetaObjectHandler implements MetaObjectHandler {
    /**
     * 增加时填充
     *
     * @param metaObject 元数据
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        String date = formatDate();
        setFieldValByName("gmtCreated", date, metaObject);
        setFieldValByName("gmtModified", date, metaObject);
        setFieldValByName("logicDeleted", 0, metaObject);
    }

    /**
     * 更新时填充
     *
     * @param metaObject 元数据
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        String date = formatDate();
        setFieldValByName("gmtModified", date, metaObject);
    }

    /**
     * 格式化当前时间
     *
     * @return 格式化后的时间字符串
     */
    private String formatDate() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
