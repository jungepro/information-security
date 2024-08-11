package com.ruoyi.mall.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mall.mapper.MallCartMapper;
import com.ruoyi.mall.domain.MallCart;
import com.ruoyi.mall.service.IMallCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 购物车Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
@Service
public class MallCartServiceImpl implements IMallCartService 
{
    private static final Logger logger = LoggerFactory.getLogger(MallCartServiceImpl.class);

    @Autowired
    private MallCartMapper mallCartMapper;

    /**
     * 查询购物车
     * 
     * @param cartId 购物车ID
     * @return 购物车
     */
    @Override
    public MallCart selectMallCartById(Long cartId)
    {
        return mallCartMapper.selectMallCartById(cartId);
    }

    /**
     * 查询购物车列表
     * 
     * @param mallCart 购物车
     * @return 购物车
     */
    @Override
    public List<MallCart> selectMallCartList(MallCart mallCart)
    {
        return mallCartMapper.selectMallCartList(mallCart);
    }

    /**
     * 新增购物车
     * 
     * @param mallCart 购物车
     * @return 结果
     */
    @Override
    public int insertMallCart(MallCart mallCart)
    {
        mallCart.setUserId(SecurityUtils.getLoginUser().getUser().getUserId());

        //查询此商品是否已存在于购物车中
        MallCart cartQuery = new MallCart();
        cartQuery.setspuId(mallCart.getspuId());
        cartQuery.setUserId(SecurityUtils.getLoginUser().getUser().getUserId());
        List<MallCart> cartList = mallCartMapper.selectMallCartList(cartQuery);
        if (cartList.isEmpty()) {
            mallCart.setCreateTime(DateUtils.getNowDate());
            return mallCartMapper.insertMallCart(mallCart);
        } else {
            MallCart newMallCart = cartList.get(0);
            newMallCart.setNum(mallCart.getNum() + newMallCart.getNum());
            return mallCartMapper.updateMallCart(newMallCart);
        }
    }

    /**
     * 修改购物车
     * 
     * @param mallCart 购物车
     * @return 结果
     */
    @Override
    public int updateMallCart(MallCart mallCart)
    {
        return mallCartMapper.updateMallCart(mallCart);
    }

    /**
     * 批量删除购物车
     * 
     * @param cartIds 需要删除的购物车ID
     * @return 结果
     */
    @Override
    public int deleteMallCartByIds(Long[] cartIds)
    {
        return mallCartMapper.deleteMallCartByIds(cartIds);
    }

    /**
     * 删除购物车信息
     * 
     * @param cartId 购物车ID
     * @return 结果
     */
    @Override
    public int deleteMallCartById(Long cartId)
    {
        return mallCartMapper.deleteMallCartById(cartId);
    }
}
