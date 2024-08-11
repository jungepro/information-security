package com.ruoyi.mall.service;

import java.util.List;
import com.ruoyi.mall.domain.MallOrder;

/**
 * 订单Service接口
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
public interface IMallOrderService 
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
     * 批量删除订单
     * 
     * @param orderIds 需要删除的订单ID
     * @return 结果
     */
    public int deleteMallOrderByIds(Long[] orderIds);

    /**
     * 删除订单信息
     * 
     * @param orderId 订单ID
     * @return 结果
     */
    public int deleteMallOrderById(Long orderId);
}
