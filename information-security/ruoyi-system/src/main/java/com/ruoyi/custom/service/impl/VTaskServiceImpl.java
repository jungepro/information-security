package com.ruoyi.custom.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.custom.mapper.VTaskMapper;
import com.ruoyi.custom.domain.VTask;
import com.ruoyi.custom.service.IVTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * VIEWService业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
@Service
public class VTaskServiceImpl implements IVTaskService 
{
    private static final Logger logger = LoggerFactory.getLogger(VTaskServiceImpl.class);

    @Autowired
    private VTaskMapper vTaskMapper;

    /**
     * 查询VIEW
     * 
     * @param taskId VIEWID
     * @return VIEW
     */
    @Override
    public VTask selectVTaskById(Long taskId)
    {
        return vTaskMapper.selectVTaskById(taskId);
    }

    /**
     * 查询VIEW列表
     * 
     * @param vTask VIEW
     * @return VIEW
     */
    @Override
    public List<VTask> selectVTaskList(VTask vTask)
    {
        return vTaskMapper.selectVTaskList(vTask);
    }

    /**
     * 新增VIEW
     * 
     * @param vTask VIEW
     * @return 结果
     */
    @Override
    public int insertVTask(VTask vTask)
    {
        vTask.setCreateTime(DateUtils.getNowDate());
        return vTaskMapper.insertVTask(vTask);
    }

    /**
     * 修改VIEW
     * 
     * @param vTask VIEW
     * @return 结果
     */
    @Override
    public int updateVTask(VTask vTask)
    {
        vTask.setUpdateTime(DateUtils.getNowDate());
        return vTaskMapper.updateVTask(vTask);
    }

    /**
     * 批量删除VIEW
     * 
     * @param taskIds 需要删除的VIEWID
     * @return 结果
     */
    @Override
    public int deleteVTaskByIds(Long[] taskIds)
    {
        return vTaskMapper.deleteVTaskByIds(taskIds);
    }

    /**
     * 删除VIEW信息
     * 
     * @param taskId VIEWID
     * @return 结果
     */
    @Override
    public int deleteVTaskById(Long taskId)
    {
        return vTaskMapper.deleteVTaskById(taskId);
    }
}
