package com.ruoyi.mall.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mall.mapper.MallAddressMapper;
import com.ruoyi.mall.domain.MallAddress;
import com.ruoyi.mall.service.IMallAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 地址Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
@Service
public class MallAddressServiceImpl implements IMallAddressService 
{
    private static final Logger logger = LoggerFactory.getLogger(MallAddressServiceImpl.class);

    @Autowired
    private MallAddressMapper mallAddressMapper;

    /**
     * 查询地址
     * 
     * @param addressId 地址ID
     * @return 地址
     */
    @Override
    public MallAddress selectMallAddressById(Long addressId)
    {
        return mallAddressMapper.selectMallAddressById(addressId);
    }

    /**
     * 查询地址列表
     * 
     * @param mallAddress 地址
     * @return 地址
     */
    @Override
    public List<MallAddress> selectMallAddressList(MallAddress mallAddress)
    {
        return mallAddressMapper.selectMallAddressList(mallAddress);
    }

    /**
     * 新增地址
     * 
     * @param mallAddress 地址
     * @return 结果
     */
    @Override
    public int insertMallAddress(MallAddress mallAddress)
    {
        //取消原来的默认地址
        if ("1".equals(mallAddress.getDefaultAddress())) {
            MallAddress addressQuery = new MallAddress();
            addressQuery.setUserId(SecurityUtils.getLoginUser().getUser().getUserId());
            addressQuery.setDefaultAddress("1");
            List<MallAddress> addressList = mallAddressMapper.selectMallAddressList(addressQuery);
            if (!addressList.isEmpty()) {
                MallAddress addressUpdate = new MallAddress();
                addressUpdate.setAddressId(addressList.get(0).getAddressId());
                addressUpdate.setDefaultAddress("0");
                mallAddressMapper.updateMallAddress(addressUpdate);
            }
        }
        mallAddress.setUserId(SecurityUtils.getLoginUser().getUser().getUserId());
        mallAddress.setCreateTime(DateUtils.getNowDate());
        return mallAddressMapper.insertMallAddress(mallAddress);
    }

    /**
     * 修改地址
     * 
     * @param mallAddress 地址
     * @return 结果
     */
    @Override
    public int updateMallAddress(MallAddress mallAddress)
    {
        //取消原来的默认地址
        if ("1".equals(mallAddress.getDefaultAddress())) {
            MallAddress addressQuery = new MallAddress();
            addressQuery.setUserId(SecurityUtils.getLoginUser().getUser().getUserId());
            addressQuery.setDefaultAddress("1");
            List<MallAddress> addressList = mallAddressMapper.selectMallAddressList(addressQuery);
            if (!addressList.isEmpty()) {
                MallAddress addressUpdate = new MallAddress();
                addressUpdate.setAddressId(addressList.get(0).getAddressId());
                addressUpdate.setDefaultAddress("0");
                mallAddressMapper.updateMallAddress(addressUpdate);
            }
        }
        mallAddress.setUpdateTime(DateUtils.getNowDate());
        return mallAddressMapper.updateMallAddress(mallAddress);
    }

    /**
     * 批量删除地址
     * 
     * @param addressIds 需要删除的地址ID
     * @return 结果
     */
    @Override
    public int deleteMallAddressByIds(Long[] addressIds)
    {
        return mallAddressMapper.deleteMallAddressByIds(addressIds);
    }

    /**
     * 删除地址信息
     * 
     * @param addressId 地址ID
     * @return 结果
     */
    @Override
    public int deleteMallAddressById(Long addressId)
    {
        return mallAddressMapper.deleteMallAddressById(addressId);
    }
}
