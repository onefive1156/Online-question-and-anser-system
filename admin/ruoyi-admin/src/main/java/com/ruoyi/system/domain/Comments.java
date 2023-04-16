package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 评论管理对象 comments
 * 
 * @author felix
 * @date 2023-04-16
 */
public class Comments extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评论id */
    private Long id;

    /** 作者id */
    @Excel(name = "作者id")
    private Long authorId;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private Long likes;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 属于 */
    @Excel(name = "属于")
    private String belongsTo;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Long delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAuthorId(Long authorId) 
    {
        this.authorId = authorId;
    }

    public Long getAuthorId() 
    {
        return authorId;
    }
    public void setLikes(Long likes) 
    {
        this.likes = likes;
    }

    public Long getLikes() 
    {
        return likes;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setBelongsTo(String belongsTo) 
    {
        this.belongsTo = belongsTo;
    }

    public String getBelongsTo() 
    {
        return belongsTo;
    }
    public void setDelFlag(Long delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Long getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("authorId", getAuthorId())
            .append("likes", getLikes())
            .append("type", getType())
            .append("belongsTo", getBelongsTo())
            .append("createTime", getCreateTime())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
