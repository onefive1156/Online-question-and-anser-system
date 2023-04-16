package com.ruoyi.system.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 问题管理对象 problem
 * 
 * @author felix
 * @date 2023-04-16
 */
public class Problem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 问题id */
    private Long id;

    /** 问题名称 */
    @Excel(name = "问题名称")
    private String name;

    /** 作者id
 */
    @Excel(name = "作者id ")
    private Long authorId;

    /** 问题描述
 */
    @Excel(name = "问题描述 ")
    private String details;

    /** 问题图片路径 */
    @Excel(name = "问题图片路径")
    private String imgUrl;

    /**  */
    private Long delFlag;

    /** 回答管理信息 */
    private List<Answer> answerList;

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
    public void setDelFlag(Long delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Long getDelFlag() 
    {
        return delFlag;
    }

    public List<Answer> getAnswerList()
    {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList)
    {
        this.answerList = answerList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("authorId", getAuthorId())
            .append("details", getDetails())
            .append("imgUrl", getImgUrl())
            .append("createTime", getCreateTime())
            .append("delFlag", getDelFlag())
            .append("answerList", getAnswerList())
            .toString();
    }
}
