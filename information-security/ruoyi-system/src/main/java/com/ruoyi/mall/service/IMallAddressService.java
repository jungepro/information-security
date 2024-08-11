package com.ruoyi.mall.service;

import java.util.List;
import com.ruoyi.mall.domain.MallAddress;

/**
 * 地址Service接口
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
public interface IMallAddressService 
{
    /**
     * 查询地址
     * 
     * @param addressId 地址ID
     * @return 地址
     */
    public MallAddress selectMallAddressById(Long addressId);

    /**
     * 查询地址列表
     * 
     * @param mallAddress 地址
     * @return 地址集合
     */
    public List<MallAddress> selectMallAddressList(MallAddress mallAddress);

    /**
     * 新增地址
     * 
     * @param mallAddress 地址
     * @return 结果
     */
    public int insertMallAddress(MallAddress mallAddress);

    /**
     * 修改地址
     * 
     * @param mallAddress 地址
     * @return 结果
     */
    public int updateMallAddress(MallAddress mallAddress);

    /**
     * 批量删除地址
     * 
     * @param addressIds 需要删除的地址ID
     * @return 结果
     */
    public int deleteMallAddressByIds(Long[] addressIds);

    /**
     * 删除地址信息
     * 
     * @param addressId 地址ID
     * @return 结果
     */
    public int deleteMallAddressById(Long addressId);
}
