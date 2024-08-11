package com.ruoyi.mall.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品对象 mall_spu
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
public class MallSpu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long spuId;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 销量 */
    @Excel(name = "销量")
    private Long sales;

    /** 库存 */
    @Excel(name = "库存")
    private Long stock;

    /** 收藏 */
    @Excel(name = "收藏")
    private Boolean favorite;

    /** 图片 */
    @Excel(name = "图片")
    private String img;

    /** 详情 */
    private String detail;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    /** 分类 */
    private Long categoryId;

    /** $column.columnComment */
    private Long freightTemplateId;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** $column.columnComment */
    private String status;

    /** $column.columnComment */
    private Long activityType;

    /** $column.columnComment */
    private Long activityId;

    /** 数量 */
    private Long num;

    public void setSpuId(Long spuId)
    {
        this.spuId = spuId;
    }

    public Long getSpuId() 
    {
        return spuId;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setSales(Long sales) 
    {
        this.sales = sales;
    }

    public Long getSales() 
    {
        return sales;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }
    public void setDetail(String detail) 
    {
        this.detail = detail;
    }

    public String getDetail() 
    {
        return detail;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }
    public void setFreightTemplateId(Long freightTemplateId) 
    {
        this.freightTemplateId = freightTemplateId;
    }

    public Long getFreightTemplateId() 
    {
        return freightTemplateId;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setActivityType(Long activityType) 
    {
        this.activityType = activityType;
    }

    public Long getActivityType() 
    {
        return activityType;
    }
    public void setActivityId(Long activityId) 
    {
        this.activityId = activityId;
    }

    public Long getActivityId() 
    {
        return activityId;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "MallSpu{" +
                "spuId=" + spuId +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", sales=" + sales +
                ", stock=" + stock +
                ", favorite=" + favorite +
                ", img='" + img + '\'' +
                ", detail='" + detail + '\'' +
                ", description='" + description + '\'' +
                ", categoryId=" + categoryId +
                ", freightTemplateId=" + freightTemplateId +
                ", unit='" + unit + '\'' +
                ", status='" + status + '\'' +
                ", activityType=" + activityType +
                ", activityId=" + activityId +
                ", num=" + num +
                '}';
    }
}
