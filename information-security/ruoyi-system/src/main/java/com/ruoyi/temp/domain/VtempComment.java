package com.ruoyi.temp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * VIEW对象 vtemp_comment
 * 
 * @author ruoyi
 * @date 2021-11-18
 */
public class VtempComment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long commentId;

    /** 新闻编号 */
    private Long newsId;

    /** 用户编号 */
    private Long userId;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 评论 */
    @Excel(name = "评论")
    private String comment;

    /** 备用字段1 */
    private String text1;

    /** 备用字段2 */
    private String text2;

    /** 备用字段3 */
    private String text3;

    /** 标题 */
    @Excel(name = "标题")
    private String newsTitle;

    /** 头像地址 */
    private String userAvatar;

    /** 用户昵称 */
    private String nickName;

    public void setCommentId(Long commentId) 
    {
        this.commentId = commentId;
    }

    public Long getCommentId() 
    {
        return commentId;
    }
    public void setNewsId(Long newsId) 
    {
        this.newsId = newsId;
    }

    public Long getNewsId() 
    {
        return newsId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setComment(String comment) 
    {
        this.comment = comment;
    }

    public String getComment() 
    {
        return comment;
    }
    public void setText1(String text1) 
    {
        this.text1 = text1;
    }

    public String getText1() 
    {
        return text1;
    }
    public void setText2(String text2) 
    {
        this.text2 = text2;
    }

    public String getText2() 
    {
        return text2;
    }
    public void setText3(String text3) 
    {
        this.text3 = text3;
    }

    public String getText3() 
    {
        return text3;
    }
    public void setNewsTitle(String newsTitle) 
    {
        this.newsTitle = newsTitle;
    }

    public String getNewsTitle() 
    {
        return newsTitle;
    }
    public void setUserAvatar(String userAvatar) 
    {
        this.userAvatar = userAvatar;
    }

    public String getUserAvatar() 
    {
        return userAvatar;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("commentId", getCommentId())
            .append("newsId", getNewsId())
            .append("userId", getUserId())
            .append("title", getTitle())
            .append("comment", getComment())
            .append("createTime", getCreateTime())
            .append("text1", getText1())
            .append("text2", getText2())
            .append("text3", getText3())
            .append("newsTitle", getNewsTitle())
            .append("userAvatar", getUserAvatar())
            .append("nickName", getNickName())
            .toString();
    }
}
