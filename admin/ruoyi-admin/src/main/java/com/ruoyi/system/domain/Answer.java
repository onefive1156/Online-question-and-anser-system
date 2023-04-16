package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 回答管理对象 answer
 * 
 * @author felix
 * @date 2023-04-16
 */
public class Answer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /**  */
    @Excel(name = "")
    private String name;

    /**  */
    @Excel(name = "")
    private Long authorId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String details;

    /**  */
    @Excel(name = "")
    private String imgUrl;

    /**  */
    @Excel(name = "")
    private Long likes;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date editeTime;

    /**  */
    private Long delFlag;

    /**  */
    @Excel(name = "")
    private Long belongsTo;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setAuthorId(Long authorId) 
    {
        this.authorId = authorId;
    }

    public Long getAuthorId() 
    {
        return authorId;
    }
    public void setDetails(String details) 
    {
        this.details = details;
    }

    public String getDetails() 
    {
        return details;
    }
    public void setImgUrl(String imgUrl) 
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() 
    {
        return imgUrl;
    }
    public void setLikes(Long likes) 
    {
        this.likes = likes;
    }

    public Long getLikes() 
    {
        return likes;
    }
    public void setEditeTime(Date editeTime) 
    {
        this.editeTime = editeTime;
    }

    public Date getEditeTime() 
    {
        return editeTime;
    }
    public void setDelFlag(Long delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Long getDelFlag() 
    {
        return delFlag;
    }
    public void setBelongsTo(Long belongsTo) 
    {
        this.belongsTo = belongsTo;
    }

    public Long getBelongsTo() 
    {
        return belongsTo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("authorId", getAuthorId())
            .append("details", getDetails())
            .append("imgUrl", getImgUrl())
            .append("likes", getLikes())
            .append("createTime", getCreateTime())
            .append("editeTime", getEditeTime())
            .append("delFlag", getDelFlag())
            .append("belongsTo", getBelongsTo())
            .toString();
    }
}
