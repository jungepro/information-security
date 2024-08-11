package com.ruoyi.custom.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 申请对象 t_shenqin
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public class TShenqin extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 介绍 */
    @Excel(name = "介绍")
    private String info;

    /** 附件 */
    @Excel(name = "附件")
    private String url;

    /** 级别 */
    @Excel(name = "级别")
    private String lvl;

    /** 意见 */
    @Excel(name = "意见")
    private String advice;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setInfo(String info) 
    {
        this.info = info;
    }

    public String getInfo() 
    {
        return info;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }
    public void setLvl(String lvl) 
    {
        this.lvl = lvl;
    }

    public String getLvl() 
    {
        return lvl;
    }
    public void setAdvice(String advice) 
    {
        this.advice = advice;
    }

    public String getAdvice() 
    {
        return advice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("info", getInfo())
            .append("url", getUrl())
            .append("lvl", getLvl())
            .append("advice", getAdvice())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
