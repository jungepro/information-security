package com.ruoyi.mall.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 购物车对象 mall_cart
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
public class MallCart extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long cartId;

    /** 商品 */
    private Long spuId;

    /** 用户 */
    private Long userId;

    /** 数量 */
    private Long num;

    /** 图片 */
    private String img;

    /** 标题 */
    private String title;

    /** 价格 */
    private Double price;

    public void setCartId(Long cartId)
    {
        this.cartId = cartId;
    }

    public Long getCartId() 
    {
        return cartId;
    }
    public void setspuId(Long spuId)
    {
        this.spuId = spuId;
    }

    public Long getspuId()
    {
        return spuId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setNum(Long num) 
    {
        this.num = num;
    }

    public Long getNum() 
    {
        return num;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MallCart{" +
                "cartId=" + cartId +
                ", spuId=" + spuId +
                ", userId=" + userId +
                ", num=" + num +
                ", img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
