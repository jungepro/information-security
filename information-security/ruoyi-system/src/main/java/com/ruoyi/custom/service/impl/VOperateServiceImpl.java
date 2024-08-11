package com.ruoyi.custom.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.custom.mapper.VOperateMapper;
import com.ruoyi.custom.domain.VOperate;
import com.ruoyi.custom.service.IVOperateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * VIEWService业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
@Service
public class VOperateServiceImpl implements IVOperateService 
{
    private static final Logger logger = LoggerFactory.getLogger(VOperateServiceImpl.class);

    @Autowired
    private VOperateMapper vOperateMapper;

    /**
     * 查询VIEW
     * 
     * @param operateId VIEWID
     * @return VIEW
     */
    @Override
    public VOperate selectVOperateById(Long operateId)
    {
        return vOperateMapper.selectVOperateById(operateId);
    }

    /**
     * 查询VIEW列表
     * 
     * @param vOperate VIEW
     * @return VIEW
     */
    @Override
    public List<VOperate> selectVOperateList(VOperate vOperate)
    {
        return vOperateMapper.selectVOperateList(vOperate);
    }

    /**
     * 新增VIEW
     * 
     * @param vOperate VIEW
     * @return 结果
     */
    @Override
    public int insertVOperate(VOperate vOperate)
    {
        vOperate.setCreateTime(DateUtils.getNowDate());
        return vOperateMapper.insertVOperate(vOperate);
    }

    /**
     * 修改VIEW
     * 
     * @param vOperate VIEW
     * @return 结果
     */
    @Override
    public int updateVOperate(VOperate vOperate)
    {
        vOperate.setUpdateTime(DateUtils.getNowDate());
        return vOperateMapper.updateVOperate(vOperate);
    }

    /**
     * 批量删除VIEW
     * 
     * @param operateIds 需要删除的VIEWID
     * @return 结果
     */
    @Override
    public int deleteVOperateByIds(Long[] operateIds)
    {
        return vOperateMapper.deleteVOperateByIds(operateIds);
    }

    /**
     * 删除VIEW信息
     * 
     * @param operateId VIEWID
     * @return 结果
     */
    @Override
    public int deleteVOperateById(Long operateId)
    {
        return vOperateMapper.deleteVOperateById(operateId);
    }
}
