package com.ruoyi.custom.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 操作手册对象 t_file
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
public class TFile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long fileId;

    /** 资料名 */
    @Excel(name = "资料名")
    private String fileName;

    /** 附件 */
    @Excel(name = "附件")
    private String file;

    /** 描述 */
    @Excel(name = "描述")
    private String detail;

    /** 备用字段1 */
    private String text1;

    /** 备用字段2 */
    private String text2;

    /** 备用字段3 */
    private String text3;

    public void setFileId(Long fileId) 
    {
        this.fileId = fileId;
    }

    public Long getFileId() 
    {
        return fileId;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setFile(String file) 
    {
        this.file = file;
    }

    public String getFile() 
    {
        return file;
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
            .append("fileId", getFileId())
            .append("fileName", getFileName())
            .append("file", getFile())
            .append("detail", getDetail())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("text1", getText1())
            .append("text2", getText2())
            .append("text3", getText3())
            .toString();
    }
}
