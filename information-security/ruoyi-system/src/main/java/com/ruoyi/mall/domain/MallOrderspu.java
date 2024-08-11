package com.ruoyi.mall.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 订单商品对照对象 mall_orderspu
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
public class MallOrderspu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long orderspuId;

    /** 订单 */
    private Long orderId;

    /** 商品 */
    private Long spuId;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 图片 */
    @Excel(name = "图片")
    private String img;

    /** 数量 */
    private Long num;

    public void setOrderspuId(Long orderspuId)
    {
        this.orderspuId = orderspuId;
    }

    public Long getOrderspuId() 
    {
        return orderspuId;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setSpuId(Long spuId) 
    {
        this.spuId = spuId;
    }

    public Long getSpuId() 
    {
        return spuId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "MallOrderspu{" +
                "orderspuId=" + orderspuId +
                ", orderId=" + orderId +
                ", spuId=" + spuId +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", num=" + num +
                '}';
    }
}
