package com.ruoyi.mall.mapper;

import java.util.List;
import com.ruoyi.mall.domain.MallOrder;

/**
 * 订单Mapper接口
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
public interface MallOrderMapper 
{
    /**
     * 查询订单
     * 
     * @param orderId 订单ID
     * @return 订单
     */
    public MallOrder selectMallOrderById(Long orderId);

    /**
     * 查询订单列表
     * 
     * @param mallOrder 订单
     * @return 订单集合
     */
    public List<MallOrder> selectMallOrderList(MallOrder mallOrder);

    /**
     * 新增订单
     * 
     * @param mallOrder 订单
     * @return 结果
     */
    public int insertMallOrder(MallOrder mallOrder);

    /**
     * 修改订单
     * 
     * @param mallOrder 订单
     * @return 结果
     */
    public int updateMallOrder(MallOrder mallOrder);

    /**
     * 删除订单
     * 
     * @param orderId 订单ID
     * @return 结果
     */
    public int deleteMallOrderById(Long orderId);

    /**
     * 批量删除订单
     * 
     * @param orderIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMallOrderByIds(Long[] orderIds);

    /**
     * 自定义sql订单查询
     */
    public List customMallOrderSql(MallOrder mallOrder);
}
