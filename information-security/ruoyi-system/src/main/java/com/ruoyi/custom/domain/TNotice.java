package com.ruoyi.custom.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 系统公告对象 t_notice
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
public class TNotice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long noticeId;

    /** 标题 */
    @Excel(name = "标题")
    private String noticeName;

    /** 图片 */
    @Excel(name = "图片")
    private String image;

    /** 详情 */
    @Excel(name = "详情")
    private String detail;

    /** 备用字段1 */
    private String text1;

    /** 备用字段2 */
    private String text2;

    /** 备用字段3 */
    private String text3;

    public void setNoticeId(Long noticeId) 
    {
        this.noticeId = noticeId;
    }

    public Long getNoticeId() 
    {
        return noticeId;
    }
    public void setNoticeName(String noticeName) 
    {
        this.noticeName = noticeName;
    }

    public String getNoticeName() 
    {
        return noticeName;
    }
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }
    public void setDetail(String detail) 
    {
        this.detail = detail;
    }

    public String getDetail() 
    {
        return detail;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("noticeId", getNoticeId())
            .append("noticeName", getNoticeName())
            .append("image", getImage())
            .append("detail", getDetail())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("text1", getText1())
            .append("text2", getText2())
            .append("text3", getText3())
            .toString();
    }
}
