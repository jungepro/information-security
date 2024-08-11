package com.ruoyi.mall.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mall.mapper.MallFavoriteMapper;
import com.ruoyi.mall.domain.MallFavorite;
import com.ruoyi.mall.service.IMallFavoriteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 收藏Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
@Service
public class MallFavoriteServiceImpl implements IMallFavoriteService 
{
    private static final Logger logger = LoggerFactory.getLogger(MallFavoriteServiceImpl.class);

    @Autowired
    private MallFavoriteMapper mallFavoriteMapper;

    /**
     * 查询收藏
     * 
     * @param favoriteId 收藏ID
     * @return 收藏
     */
    @Override
    public MallFavorite selectMallFavoriteById(Long favoriteId)
    {
        return mallFavoriteMapper.selectMallFavoriteById(favoriteId);
    }

    /**
     * 查询收藏列表
     * 
     * @param mallFavorite 收藏
     * @return 收藏
     */
    @Override
    public List<MallFavorite> selectMallFavoriteList(MallFavorite mallFavorite)
    {
        return mallFavoriteMapper.selectMallFavoriteList(mallFavorite);
    }

    /**
     * 新增收藏
     * 
     * @param mallFavorite 收藏
     * @return 结果
     */
    @Override
    public int insertMallFavorite(MallFavorite mallFavorite)
    {
        mallFavorite.setUserId(SecurityUtils.getLoginUser().getUser().getUserId());
        mallFavorite.setCreateTime(DateUtils.getNowDate());
        return mallFavoriteMapper.insertMallFavorite(mallFavorite);
    }

    /**
     * 修改收藏
     * 
     * @param mallFavorite 收藏
     * @return 结果
     */
    @Override
    public int updateMallFavorite(MallFavorite mallFavorite)
    {
        return mallFavoriteMapper.updateMallFavorite(mallFavorite);
    }

    /**
     * 批量删除收藏
     * 
     * @param favoriteIds 需要删除的收藏ID
     * @return 结果
     */
    @Override
    public int deleteMallFavoriteByIds(Long[] favoriteIds)
    {
        return mallFavoriteMapper.deleteMallFavoriteByIds(favoriteIds);
    }

    /**
     * 删除收藏信息
     * 
     * @param favoriteId 收藏ID
     * @return 结果
     */
    @Override
    public int deleteMallFavoriteById(Long favoriteId)
    {
        return mallFavoriteMapper.deleteMallFavoriteById(favoriteId);
    }
}
