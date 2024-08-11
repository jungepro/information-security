package com.ruoyi.mall.service.impl;

import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.mall.domain.MallFavorite;
import com.ruoyi.mall.mapper.MallFavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mall.mapper.MallSpuMapper;
import com.ruoyi.mall.domain.MallSpu;
import com.ruoyi.mall.service.IMallSpuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
@Service
public class MallSpuServiceImpl implements IMallSpuService 
{
    private static final Logger logger = LoggerFactory.getLogger(MallSpuServiceImpl.class);

    @Autowired
    private MallSpuMapper mallSpuMapper;
    @Autowired
    private MallFavoriteMapper mallFavoriteMapper;

    /**
     * 查询商品
     * 
     * @param spuId 商品ID
     * @return 商品
     */
    @Override
    public MallSpu selectMallSpuById(Long spuId)
    {
        //查询是否已收藏商品
        MallFavorite favorite = new MallFavorite();
        favorite.setUserId(SecurityUtils.getLoginUser().getUser().getUserId());
        favorite.setUserId(spuId);
        List<MallFavorite> favoriteList = mallFavoriteMapper.selectMallFavoriteList(favorite);

        MallSpu mallSpu = mallSpuMapper.selectMallSpuById(spuId);
        mallSpu.setFavorite(!favoriteList.isEmpty());
        return mallSpu;
    }

    /**
     * 查询商品列表
     * 
     * @param mallSpu 商品
     * @return 商品
     */
    @Override
    public List<MallSpu> selectMallSpuList(MallSpu mallSpu)
    {
        return mallSpuMapper.selectMallSpuList(mallSpu);
    }

    /**
     * 新增商品
     * 
     * @param mallSpu 商品
     * @return 结果
     */
    @Override
    public int insertMallSpu(MallSpu mallSpu)
    {
        return mallSpuMapper.insertMallSpu(mallSpu);
    }

    /**
     * 修改商品
     * 
     * @param mallSpu 商品
     * @return 结果
     */
    @Override
    public int updateMallSpu(MallSpu mallSpu)
    {
        return mallSpuMapper.updateMallSpu(mallSpu);
    }

    /**
     * 批量删除商品
     * 
     * @param spuIds 需要删除的商品ID
     * @return 结果
     */
    @Override
    public int deleteMallSpuByIds(Long[] spuIds)
    {
        return mallSpuMapper.deleteMallSpuByIds(spuIds);
    }

    /**
     * 删除商品信息
     * 
     * @param spuId 商品ID
     * @return 结果
     */
    @Override
    public int deleteMallSpuById(Long spuId)
    {
        return mallSpuMapper.deleteMallSpuById(spuId);
    }
}
