package com.ruoyi.mall.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 地址对象 mall_address
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
public class MallAddress extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long addressId;

    /** 地址 */
    private String address;

    /** 是否默认地址 */
    private String defaultAddress;

    /** 用户 */
    private Long userId;

    /** 电话 */
    private String phone;

    /** 收货人 */
    private String consignee;

    public void setAddressId(Long addressId) 
    {
        this.addressId = addressId;
    }

    public Long getAddressId() 
    {
        return addressId;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setDefaultAddress(String defaultAddress) 
    {
        this.defaultAddress = defaultAddress;
    }

    public String getDefaultAddress() 
    {
        return defaultAddress;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setConsignee(String consignee) 
    {
        this.consignee = consignee;
    }

    public String getConsignee() 
    {
        return consignee;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("addressId", getAddressId())
            .append("address", getAddress())
            .append("defaultAddress", getDefaultAddress())
            .append("userId", getUserId())
            .append("phone", getPhone())
            .append("consignee", getConsignee())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
