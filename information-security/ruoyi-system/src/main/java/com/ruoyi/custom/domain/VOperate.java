package com.ruoyi.custom.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * VIEW对象 v_operate
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
public class VOperate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long operateId;

    /** 用户 */
    @Excel(name = "用户")
    private Long userId;

    /** 任务 */
    @Excel(name = "任务")
    private String operateName;

    /** 操作日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "操作日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date operateDate;

    /** 详细描述 */
    @Excel(name = "详细描述")
    private String detail;

    /** 备用字段1 */
    private String text1;

    /** 备用字段2 */
    private String text2;

    /** 备用字段3 */
    private String text3;

    /** 用户昵称 */
    private String nickName;

    public void setOperateId(Long operateId) 
    {
        this.operateId = operateId;
    }

    public Long getOperateId() 
    {
        return operateId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setOperateName(String operateName) 
    {
        this.operateName = operateName;
    }

    public String getOperateName() 
    {
        return operateName;
    }
    public void setOperateDate(Date operateDate) 
    {
        this.operateDate = operateDate;
    }

    public Date getOperateDate() 
    {
        return operateDate;
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
            .append("operateId", getOperateId())
            .append("userId", getUserId())
            .append("operateName", getOperateName())
            .append("operateDate", getOperateDate())
            .append("detail", getDetail())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("text1", getText1())
            .append("text2", getText2())
            .append("text3", getText3())
            .append("nickName", getNickName())
            .toString();
    }
}
