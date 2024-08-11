package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.enums.EStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * Entity基类
 *
 * @author 陌溪
 * @date 2018年9月17日09:47:12
 */
@SuppressWarnings("rawtypes")
public class SuperEntity {

    /**
     *
     */
    private static final long serialVersionUID = -4851055162892178225L;

    /**
     * 唯一UID
     */
    private String uid;

    /**
     * 状态 0：失效  1：生效
     */
    private int status;

    /**
     * @TableField 配置需要填充的字段
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public SuperEntity() {
        this.status = EStatus.ENABLE;
        this.createTime = new Date();
        this.updateTime = new Date();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "SuperEntity{" +
                "uid='" + uid + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}