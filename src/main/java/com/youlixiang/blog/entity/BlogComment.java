package com.youlixiang.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 文章评论
 * </p>
 *
 * @author 郭非
 * @since 2022-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="BlogComment对象", description="")
public class BlogComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论编号")
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Integer commentId;

    @ApiModelProperty(value = "文章编号")
    private Integer articleId;

    @ApiModelProperty(value = "评论内容")
    private String context;

    @ApiModelProperty(value = "用户编号")
    private String username;

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
