package com.ruoyi.mall.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 收藏对象 mall_favorite
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
public class MallFavorite extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long favoriteId;

    /** 用户 */
    private Long userId;

    /** 商品 */
    private Long spuId;

    public void setFavoriteId(Long favoriteId) 
    {
        this.favoriteId = favoriteId;
    }

    public Long getFavoriteId() 
    {
        return favoriteId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setSpuId(Long spuId) 
    {
        this.spuId = spuId;
    }

    public Long getSpuId() 
    {
        return spuId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("favoriteId", getFavoriteId())
            .append("userId", getUserId())
            .append("spuId", getSpuId())
            .append("createTime", getCreateTime())
            .toString();
    }
}
