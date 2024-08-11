package com.ruoyi.custom.service;

import java.util.List;
import com.ruoyi.custom.domain.TTask;

/**
 * 运维事项Service接口
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
public interface ITTaskService 
{
    /**
     * 查询运维事项
     * 
     * @param taskId 运维事项ID
     * @return 运维事项
     */
    public TTask selectTTaskById(Long taskId);

    /**
     * 查询运维事项列表
     * 
     * @param tTask 运维事项
     * @return 运维事项集合
     */
    public List<TTask> selectTTaskList(TTask tTask);

    /**
     * 新增运维事项
     * 
     * @param tTask 运维事项
     * @return 结果
     */
    public int insertTTask(TTask tTask);

    /**
     * 修改运维事项
     * 
     * @param tTask 运维事项
     * @return 结果
     */
    public int updateTTask(TTask tTask);

    /**
     * 批量删除运维事项
     * 
     * @param taskIds 需要删除的运维事项ID
     * @return 结果
     */
    public int deleteTTaskByIds(Long[] taskIds);

    /**
     * 删除运维事项信息
     * 
     * @param taskId 运维事项ID
     * @return 结果
     */
    public int deleteTTaskById(Long taskId);
}
