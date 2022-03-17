package com.youlixiang.blog.article.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 郭非
 * @since 2022-03-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "BlogArticle对象", description = "")
public class BlogArticle implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文章编号")
    @TableId(value = "article_id", type = IdType.AUTO)
    private Integer articleId;

    @ApiModelProperty(value = "类型编号")
    private Integer typeId;

    @ApiModelProperty(value = "文章标题")
    private String articleTitle;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "浏览数量")
    private Long viewCount;

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
