package com.ruoyi.mall.service.impl;

import java.util.Date;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.mall.domain.MallOrderspu;
import com.ruoyi.mall.domain.MallSpu;
import com.ruoyi.mall.mapper.MallOrderspuMapper;
import com.ruoyi.mall.mapper.MallSpuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mall.mapper.MallOrderMapper;
import com.ruoyi.mall.domain.MallOrder;
import com.ruoyi.mall.service.IMallOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
@Service
public class MallOrderServiceImpl implements IMallOrderService 
{
    private static final Logger logger = LoggerFactory.getLogger(MallOrderServiceImpl.class);

    @Autowired
    private MallOrderMapper mallOrderMapper;
    @Autowired
    private MallOrderspuMapper mallOrderspuMapper;
    @Autowired
    private MallSpuMapper mallSpuMapper;

    /**
     * 查询订单
     * 
     * @param orderId 订单ID
     * @return 订单
     */
    @Override
    public MallOrder selectMallOrderById(Long orderId)
    {
        return mallOrderMapper.selectMallOrderById(orderId);
    }

    /**
     * 查询订单列表
     * 
     * @param mallOrder 订单
     * @return 订单
     */
    @Override
    public List<MallOrder> selectMallOrderList(MallOrder mallOrder)
    {
        List<MallOrder> orderList = mallOrderMapper.selectMallOrderList(mallOrder);
        for (int i = 0; i < orderList.size(); i++) {
            MallOrderspu orderspu = new MallOrderspu();
            orderspu.setOrderId(orderList.get(i).getOrderId());
            List<MallOrderspu> orderspuList = mallOrderspuMapper.selectMallOrderspuList(orderspu);
            orderList.get(i).setOrderspuList(orderspuList);
        }
        return orderList;
    }

    /**
     * 新增订单
     * 
     * @param mallOrder 订单
     * @return 结果
     */
    @Override
    public int insertMallOrder(MallOrder mallOrder)
    {
        mallOrder.setUserId(SecurityUtils.getLoginUser().getUser().getUserId());
        mallOrder.setCreateTime(DateUtils.getNowDate());
        mallOrderMapper.insertMallOrder(mallOrder);

        for (MallOrderspu orderspu : mallOrder.getOrderspuList()) {
            //插入订单商品对照表
            MallOrderspu mallOrderspu = new MallOrderspu();
            mallOrderspu.setOrderId(mallOrder.getOrderId());
            mallOrderspu.setSpuId(orderspu.getSpuId());
            mallOrderspu.setCreateTime(new Date());
            mallOrderspu.setTitle(orderspu.getTitle());
            mallOrderspu.setImg(orderspu.getImg());
            mallOrderspu.setPrice(orderspu.getPrice());
            mallOrderspu.setNum(orderspu.getNum());
            mallOrderspuMapper.insertMallOrderspu(mallOrderspu);

            //更新商品表的销量值、库存值
            MallSpu mallSpu = mallSpuMapper.selectMallSpuById(orderspu.getSpuId());
            mallSpu.setSales(mallSpu.getSales() + orderspu.getNum());
            mallSpu.setStock(mallSpu.getStock() - orderspu.getNum());
            mallSpuMapper.updateMallSpu(mallSpu);
        }
        return 1;
    }

    /**
     * 修改订单
     * 
     * @param mallOrder 订单
     * @return 结果
     */
    @Override
    public int updateMallOrder(MallOrder mallOrder)
    {
        mallOrder.setUpdateTime(DateUtils.getNowDate());
        return mallOrderMapper.updateMallOrder(mallOrder);
    }

    /**
     * 批量删除订单
     * 
     * @param orderIds 需要删除的订单ID
     * @return 结果
     */
    @Override
    public int deleteMallOrderByIds(Long[] orderIds)
    {
        return mallOrderMapper.deleteMallOrderByIds(orderIds);
    }

    /**
     * 删除订单信息
     * 
     * @param orderId 订单ID
     * @return 结果
     */
    @Override
    public int deleteMallOrderById(Long orderId)
    {
        return mallOrderMapper.deleteMallOrderById(orderId);
    }
}
