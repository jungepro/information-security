package com.ruoyi.custom.mapper;

import java.util.List;
import com.ruoyi.custom.domain.TTask;

/**
 * 运维事项Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
public interface TTaskMapper 
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
     * 删除运维事项
     * 
     * @param taskId 运维事项ID
     * @return 结果
     */
    public int deleteTTaskById(Long taskId);

    /**
     * 批量删除运维事项
     * 
     * @param taskIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTTaskByIds(Long[] taskIds);

    /**
     * 自定义sql运维事项查询
     */
    public List customTTaskSql(TTask tTask);
}
