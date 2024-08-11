package com.ruoyi.mall.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mall.mapper.MallOrderspuMapper;
import com.ruoyi.mall.domain.MallOrderspu;
import com.ruoyi.mall.service.IMallOrderspuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单商品对照Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
@Service
public class MallOrderspuServiceImpl implements IMallOrderspuService 
{
    private static final Logger logger = LoggerFactory.getLogger(MallOrderspuServiceImpl.class);

    @Autowired
    private MallOrderspuMapper mallOrderspuMapper;

    /**
     * 查询订单商品对照
     * 
     * @param orderspuId 订单商品对照ID
     * @return 订单商品对照
     */
    @Override
    public MallOrderspu selectMallOrderspuById(Long orderspuId)
    {
        return mallOrderspuMapper.selectMallOrderspuById(orderspuId);
    }

    /**
     * 查询订单商品对照列表
     * 
     * @param mallOrderspu 订单商品对照
     * @return 订单商品对照
     */
    @Override
    public List<MallOrderspu> selectMallOrderspuList(MallOrderspu mallOrderspu)
    {
        return mallOrderspuMapper.selectMallOrderspuList(mallOrderspu);
    }

    /**
     * 新增订单商品对照
     * 
     * @param mallOrderspu 订单商品对照
     * @return 结果
     */
    @Override
    public int insertMallOrderspu(MallOrderspu mallOrderspu)
    {
        mallOrderspu.setCreateTime(DateUtils.getNowDate());
        return mallOrderspuMapper.insertMallOrderspu(mallOrderspu);
    }

    /**
     * 修改订单商品对照
     * 
     * @param mallOrderspu 订单商品对照
     * @return 结果
     */
    @Override
    public int updateMallOrderspu(MallOrderspu mallOrderspu)
    {
        return mallOrderspuMapper.updateMallOrderspu(mallOrderspu);
    }

    /**
     * 批量删除订单商品对照
     * 
     * @param orderspuIds 需要删除的订单商品对照ID
     * @return 结果
     */
    @Override
    public int deleteMallOrderspuByIds(Long[] orderspuIds)
    {
        return mallOrderspuMapper.deleteMallOrderspuByIds(orderspuIds);
    }

    /**
     * 删除订单商品对照信息
     * 
     * @param orderspuId 订单商品对照ID
     * @return 结果
     */
    @Override
    public int deleteMallOrderspuById(Long orderspuId)
    {
        return mallOrderspuMapper.deleteMallOrderspuById(orderspuId);
    }
}
