package com.ruoyi.custom.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * VIEW对象 v_task
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
public class VTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long taskId;

    /** 用户 */
    @Excel(name = "用户")
    private Long userId;

    /** 事项名 */
    @Excel(name = "事项名")
    private String taskName;

    /** 完成日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "完成日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date taskDate;

    /** 详情 */
    @Excel(name = "详情")
    private String detail;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 备用字段1 */
    private String text1;

    /** 备用字段2 */
    private String text2;

    /** 备用字段3 */
    private String text3;

    /** 用户昵称 */
    private String nickName;

    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setTaskName(String taskName) 
    {
        this.taskName = taskName;
    }

    public String getTaskName() 
    {
        return taskName;
    }
    public void setTaskDate(Date taskDate) 
    {
        this.taskDate = taskDate;
    }

    public Date getTaskDate() 
    {
        return taskDate;
    }
    public void setDetail(String detail) 
    {
        this.detail = detail;
    }

    public String getDetail() 
    {
        return detail;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
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
            .append("taskId", getTaskId())
            .append("userId", getUserId())
            .append("taskName", getTaskName())
            .append("taskDate", getTaskDate())
            .append("detail", getDetail())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("text1", getText1())
            .append("text2", getText2())
            .append("text3", getText3())
            .append("nickName", getNickName())
            .toString();
    }
}
