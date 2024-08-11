package com.ruoyi.custom.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.custom.mapper.TOperateMapper;
import com.ruoyi.custom.domain.TOperate;
import com.ruoyi.custom.service.ITOperateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 操作日志Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
@Service
public class TOperateServiceImpl implements ITOperateService 
{
    private static final Logger logger = LoggerFactory.getLogger(TOperateServiceImpl.class);

    @Autowired
    private TOperateMapper tOperateMapper;

    /**
     * 查询操作日志
     * 
     * @param operateId 操作日志ID
     * @return 操作日志
     */
    @Override
    public TOperate selectTOperateById(Long operateId)
    {
        return tOperateMapper.selectTOperateById(operateId);
    }

    /**
     * 查询操作日志列表
     * 
     * @param tOperate 操作日志
     * @return 操作日志
     */
    @Override
    public List<TOperate> selectTOperateList(TOperate tOperate)
    {
        return tOperateMapper.selectTOperateList(tOperate);
    }

    /**
     * 新增操作日志
     * 
     * @param tOperate 操作日志
     * @return 结果
     */
    @Override
    public int insertTOperate(TOperate tOperate)
    {
        tOperate.setCreateTime(DateUtils.getNowDate());
        return tOperateMapper.insertTOperate(tOperate);
    }

    /**
     * 修改操作日志
     * 
     * @param tOperate 操作日志
     * @return 结果
     */
    @Override
    public int updateTOperate(TOperate tOperate)
    {
        tOperate.setUpdateTime(DateUtils.getNowDate());
        return tOperateMapper.updateTOperate(tOperate);
    }

    /**
     * 批量删除操作日志
     * 
     * @param operateIds 需要删除的操作日志ID
     * @return 结果
     */
    @Override
    public int deleteTOperateByIds(Long[] operateIds)
    {
        return tOperateMapper.deleteTOperateByIds(operateIds);
    }

    /**
     * 删除操作日志信息
     * 
     * @param operateId 操作日志ID
     * @return 结果
     */
    @Override
    public int deleteTOperateById(Long operateId)
    {
        return tOperateMapper.deleteTOperateById(operateId);
    }
}
