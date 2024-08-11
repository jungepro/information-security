package com.ruoyi.mall.mapper;

import java.util.List;
import com.ruoyi.mall.domain.MallOrderspu;

/**
 * 订单商品对照Mapper接口
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
public interface MallOrderspuMapper 
{
    /**
     * 查询订单商品对照
     * 
     * @param orderspuId 订单商品对照ID
     * @return 订单商品对照
     */
    public MallOrderspu selectMallOrderspuById(Long orderspuId);

    /**
     * 查询订单商品对照列表
     * 
     * @param mallOrderspu 订单商品对照
     * @return 订单商品对照集合
     */
    public List<MallOrderspu> selectMallOrderspuList(MallOrderspu mallOrderspu);

    /**
     * 新增订单商品对照
     * 
     * @param mallOrderspu 订单商品对照
     * @return 结果
     */
    public int insertMallOrderspu(MallOrderspu mallOrderspu);

    /**
     * 修改订单商品对照
     * 
     * @param mallOrderspu 订单商品对照
     * @return 结果
     */
    public int updateMallOrderspu(MallOrderspu mallOrderspu);

    /**
     * 删除订单商品对照
     * 
     * @param orderspuId 订单商品对照ID
     * @return 结果
     */
    public int deleteMallOrderspuById(Long orderspuId);

    /**
     * 批量删除订单商品对照
     * 
     * @param orderspuIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMallOrderspuByIds(Long[] orderspuIds);

    /**
     * 自定义sql订单商品对照查询
     */
    public List customMallOrderspuSql(MallOrderspu mallOrderspu);
}
