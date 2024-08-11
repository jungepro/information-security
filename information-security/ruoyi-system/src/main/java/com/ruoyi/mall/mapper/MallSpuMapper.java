package com.ruoyi.mall.mapper;

import java.util.List;
import com.ruoyi.mall.domain.MallSpu;

/**
 * 商品Mapper接口
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
public interface MallSpuMapper 
{
    /**
     * 查询商品
     * 
     * @param spuId 商品ID
     * @return 商品
     */
    public MallSpu selectMallSpuById(Long spuId);

    /**
     * 查询商品列表
     * 
     * @param mallSpu 商品
     * @return 商品集合
     */
    public List<MallSpu> selectMallSpuList(MallSpu mallSpu);

    /**
     * 新增商品
     * 
     * @param mallSpu 商品
     * @return 结果
     */
    public int insertMallSpu(MallSpu mallSpu);

    /**
     * 修改商品
     * 
     * @param mallSpu 商品
     * @return 结果
     */
    public int updateMallSpu(MallSpu mallSpu);

    /**
     * 删除商品
     * 
     * @param spuId 商品ID
     * @return 结果
     */
    public int deleteMallSpuById(Long spuId);

    /**
     * 批量删除商品
     * 
     * @param spuIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMallSpuByIds(Long[] spuIds);

    /**
     * 自定义sql商品查询
     */
    public List customMallSpuSql(MallSpu mallSpu);
}
