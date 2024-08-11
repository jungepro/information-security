package com.ruoyi.custom.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.custom.mapper.TTaskMapper;
import com.ruoyi.custom.domain.TTask;
import com.ruoyi.custom.service.ITTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 运维事项Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
@Service
public class TTaskServiceImpl implements ITTaskService 
{
    private static final Logger logger = LoggerFactory.getLogger(TTaskServiceImpl.class);

    @Autowired
    private TTaskMapper tTaskMapper;

    /**
     * 查询运维事项
     * 
     * @param taskId 运维事项ID
     * @return 运维事项
     */
    @Override
    public TTask selectTTaskById(Long taskId)
    {
        return tTaskMapper.selectTTaskById(taskId);
    }

    /**
     * 查询运维事项列表
     * 
     * @param tTask 运维事项
     * @return 运维事项
     */
    @Override
    public List<TTask> selectTTaskList(TTask tTask)
    {
        return tTaskMapper.selectTTaskList(tTask);
    }

    /**
     * 新增运维事项
     * 
     * @param tTask 运维事项
     * @return 结果
     */
    @Override
    public int insertTTask(TTask tTask)
    {
        tTask.setCreateTime(DateUtils.getNowDate());
        return tTaskMapper.insertTTask(tTask);
    }

    /**
     * 修改运维事项
     * 
     * @param tTask 运维事项
     * @return 结果
     */
    @Override
    public int updateTTask(TTask tTask)
    {
        tTask.setUpdateTime(DateUtils.getNowDate());
        return tTaskMapper.updateTTask(tTask);
    }

    /**
     * 批量删除运维事项
     * 
     * @param taskIds 需要删除的运维事项ID
     * @return 结果
     */
    @Override
    public int deleteTTaskByIds(Long[] taskIds)
    {
        return tTaskMapper.deleteTTaskByIds(taskIds);
    }

    /**
     * 删除运维事项信息
     * 
     * @param taskId 运维事项ID
     * @return 结果
     */
    @Override
    public int deleteTTaskById(Long taskId)
    {
        return tTaskMapper.deleteTTaskById(taskId);
    }
}
