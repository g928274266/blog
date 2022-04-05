package com.youlixiang.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 友链
 * </p>
 *
 * @author 郭非
 * @since 2022-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("blog_friend")
@ApiModel(value = "Friend对象", description = "")
public class BlogFriend implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "友链编号")
    @TableId(value = "friend_id", type = IdType.AUTO)
    private Integer friendId;

    @ApiModelProperty(value = "友链名称")
    private String friendName;

    @ApiModelProperty(value = "友链链接")
    private String friendUrl;

    @ApiModelProperty(value = "友链描述")
    private String friendDescribe;

    @ApiModelProperty(value = "逻辑删除(0未删除 1已删除)")
    @TableLogic
    private Integer logicDeleted;

    @ApiModelProperty(value = "增加时间")
    @TableField(fill = FieldFill.INSERT)
    private String gmtCreated;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String gmtModified;


}
