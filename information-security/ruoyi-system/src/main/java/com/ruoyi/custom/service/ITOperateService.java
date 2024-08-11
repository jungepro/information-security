package com.ruoyi.custom.service;

import java.util.List;
import com.ruoyi.custom.domain.TOperate;

/**
 * 操作日志Service接口
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
public interface ITOperateService 
{
    /**
     * 查询操作日志
     * 
     * @param operateId 操作日志ID
     * @return 操作日志
     */
    public TOperate selectTOperateById(Long operateId);

    /**
     * 查询操作日志列表
     * 
     * @param tOperate 操作日志
     * @return 操作日志集合
     */
    public List<TOperate> selectTOperateList(TOperate tOperate);

    /**
     * 新增操作日志
     * 
     * @param tOperate 操作日志
     * @return 结果
     */
    public int insertTOperate(TOperate tOperate);

    /**
     * 修改操作日志
     * 
     * @param tOperate 操作日志
     * @return 结果
     */
    public int updateTOperate(TOperate tOperate);

    /**
     * 批量删除操作日志
     * 
     * @param operateIds 需要删除的操作日志ID
     * @return 结果
     */
    public int deleteTOperateByIds(Long[] operateIds);

    /**
     * 删除操作日志信息
     * 
     * @param operateId 操作日志ID
     * @return 结果
     */
    public int deleteTOperateById(Long operateId);
}
