package com.ruoyi.mall.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.entity.SysRole;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单对象 mall_order
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
public class MallOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long orderId;

    /** 频道 */
    private String channel;

    /** 订单 */
    private String orderNo;

    /** 用户 */
    @Excel(name = "用户")
    private Long userId;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** $column.columnComment */
    private BigDecimal skuTotalPrice;

    /** $column.columnComment */
    private BigDecimal freightPrice;

    /** $column.columnComment */
    private BigDecimal couponPrice;

    /** $column.columnComment */
    private Long couponId;

    /** $column.columnComment */
    private Long groupShopId;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal actualPrice;

    /** $column.columnComment */
    private BigDecimal payPrice;

    /** $column.columnComment */
    private String payId;

    /** $column.columnComment */
    private String payChannel;

    /** $column.columnComment */
    private Date gmtPay;

    /** $column.columnComment */
    private String shipNo;

    /** $column.columnComment */
    private String shipCode;

    /** $column.columnComment */
    private Date gmtShip;

    /** $column.columnComment */
    private Date gmtConfirm;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 收货人 */
    @Excel(name = "收货人")
    private String consignee;

    /** $column.columnComment */
    private String mono;

    /** $column.columnComment */
    private Long adminMonoLevel;

    /** $column.columnComment */
    private String adminMono;

    /** $column.columnComment */
    private String refundReason;

    private List<MallOrderspu> orderspuList;

    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setChannel(String channel) 
    {
        this.channel = channel;
    }

    public String getChannel() 
    {
        return channel;
    }
    public void setOrderNo(String orderNo) 
    {
        this.orderNo = orderNo;
    }

    public String getOrderNo() 
    {
        return orderNo;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setSkuTotalPrice(BigDecimal skuTotalPrice) 
    {
        this.skuTotalPrice = skuTotalPrice;
    }

    public BigDecimal getSkuTotalPrice() 
    {
        return skuTotalPrice;
    }
    public void setFreightPrice(BigDecimal freightPrice) 
    {
        this.freightPrice = freightPrice;
    }

    public BigDecimal getFreightPrice() 
    {
        return freightPrice;
    }
    public void setCouponPrice(BigDecimal couponPrice) 
    {
        this.couponPrice = couponPrice;
    }

    public BigDecimal getCouponPrice() 
    {
        return couponPrice;
    }
    public void setCouponId(Long couponId) 
    {
        this.couponId = couponId;
    }

    public Long getCouponId() 
    {
        return couponId;
    }
    public void setGroupShopId(Long groupShopId) 
    {
        this.groupShopId = groupShopId;
    }

    public Long getGroupShopId() 
    {
        return groupShopId;
    }
    public void setActualPrice(BigDecimal actualPrice) 
    {
        this.actualPrice = actualPrice;
    }

    public BigDecimal getActualPrice() 
    {
        return actualPrice;
    }
    public void setPayPrice(BigDecimal payPrice) 
    {
        this.payPrice = payPrice;
    }

    public BigDecimal getPayPrice() 
    {
        return payPrice;
    }
    public void setPayId(String payId) 
    {
        this.payId = payId;
    }

    public String getPayId() 
    {
        return payId;
    }
    public void setPayChannel(String payChannel) 
    {
        this.payChannel = payChannel;
    }

    public String getPayChannel() 
    {
        return payChannel;
    }
    public void setGmtPay(Date gmtPay) 
    {
        this.gmtPay = gmtPay;
    }

    public Date getGmtPay() 
    {
        return gmtPay;
    }
    public void setShipNo(String shipNo) 
    {
        this.shipNo = shipNo;
    }

    public String getShipNo() 
    {
        return shipNo;
    }
    public void setShipCode(String shipCode) 
    {
        this.shipCode = shipCode;
    }

    public String getShipCode() 
    {
        return shipCode;
    }
    public void setGmtShip(Date gmtShip) 
    {
        this.gmtShip = gmtShip;
    }

    public Date getGmtShip() 
    {
        return gmtShip;
    }
    public void setGmtConfirm(Date gmtConfirm) 
    {
        this.gmtConfirm = gmtConfirm;
    }

    public Date getGmtConfirm() 
    {
        return gmtConfirm;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
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
    public void setMono(String mono) 
    {
        this.mono = mono;
    }

    public String getMono() 
    {
        return mono;
    }
    public void setAdminMonoLevel(Long adminMonoLevel) 
    {
        this.adminMonoLevel = adminMonoLevel;
    }

    public Long getAdminMonoLevel() 
    {
        return adminMonoLevel;
    }
    public void setAdminMono(String adminMono) 
    {
        this.adminMono = adminMono;
    }

    public String getAdminMono() 
    {
        return adminMono;
    }
    public void setRefundReason(String refundReason) 
    {
        this.refundReason = refundReason;
    }

    public String getRefundReason() 
    {
        return refundReason;
    }

    public List<MallOrderspu> getOrderspuList() {
        return orderspuList;
    }

    public void setOrderspuList(List<MallOrderspu> orderspuList) {
        this.orderspuList = orderspuList;
    }

    @Override
    public String toString() {
        return "MallOrder{" +
                "orderId=" + orderId +
                ", channel='" + channel + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", userId=" + userId +
                ", status='" + status + '\'' +
                ", skuTotalPrice=" + skuTotalPrice +
                ", freightPrice=" + freightPrice +
                ", couponPrice=" + couponPrice +
                ", couponId=" + couponId +
                ", groupShopId=" + groupShopId +
                ", actualPrice=" + actualPrice +
                ", payPrice=" + payPrice +
                ", payId='" + payId + '\'' +
                ", payChannel='" + payChannel + '\'' +
                ", gmtPay=" + gmtPay +
                ", shipNo='" + shipNo + '\'' +
                ", shipCode='" + shipCode + '\'' +
                ", gmtShip=" + gmtShip +
                ", gmtConfirm=" + gmtConfirm +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", consignee='" + consignee + '\'' +
                ", mono='" + mono + '\'' +
                ", adminMonoLevel=" + adminMonoLevel +
                ", adminMono='" + adminMono + '\'' +
                ", refundReason='" + refundReason + '\'' +
                ", orderspuList=" + orderspuList +
                '}';
    }
}
