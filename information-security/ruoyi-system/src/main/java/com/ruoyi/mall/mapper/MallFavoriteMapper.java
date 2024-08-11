package com.ruoyi.mall.mapper;

import java.util.List;
import com.ruoyi.mall.domain.MallFavorite;

/**
 * 收藏Mapper接口
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
public interface MallFavoriteMapper 
{
    /**
     * 查询收藏
     * 
     * @param favoriteId 收藏ID
     * @return 收藏
     */
    public MallFavorite selectMallFavoriteById(Long favoriteId);

    /**
     * 查询收藏列表
     * 
     * @param mallFavorite 收藏
     * @return 收藏集合
     */
    public List<MallFavorite> selectMallFavoriteList(MallFavorite mallFavorite);

    /**
     * 新增收藏
     * 
     * @param mallFavorite 收藏
     * @return 结果
     */
    public int insertMallFavorite(MallFavorite mallFavorite);

    /**
     * 修改收藏
     * 
     * @param mallFavorite 收藏
     * @return 结果
     */
    public int updateMallFavorite(MallFavorite mallFavorite);

    /**
     * 删除收藏
     * 
     * @param favoriteId 收藏ID
     * @return 结果
     */
    public int deleteMallFavoriteById(Long favoriteId);

    /**
     * 批量删除收藏
     * 
     * @param favoriteIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMallFavoriteByIds(Long[] favoriteIds);

    /**
     * 自定义sql收藏查询
     */
    public List customMallFavoriteSql(MallFavorite mallFavorite);
}
