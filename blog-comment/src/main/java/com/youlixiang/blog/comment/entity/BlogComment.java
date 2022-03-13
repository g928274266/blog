package com.youlixiang.blog.comment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 郭非
 * @since 2022-03-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="BlogComment对象", description="")
public class BlogComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "评论内容")
    private String context;

    @ApiModelProperty(value = "用户编号")
    private String username;

    @ApiModelProperty(value = "逻辑删除(0未删除 1已删除)")
    private Boolean logicDeleted;

    @ApiModelProperty(value = "增加时间")
    private Date gmtCreated;

    @ApiModelProperty(value = "更新时间")
    private Date gmtModified;


}
