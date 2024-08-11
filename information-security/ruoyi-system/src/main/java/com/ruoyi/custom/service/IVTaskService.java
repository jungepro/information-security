package com.ruoyi.custom.service;

import java.util.List;
import com.ruoyi.custom.domain.VTask;

/**
 * VIEWService接口
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
public interface IVTaskService 
{
    /**
     * 查询VIEW
     * 
     * @param taskId VIEWID
     * @return VIEW
     */
    public VTask selectVTaskById(Long taskId);

    /**
     * 查询VIEW列表
     * 
     * @param vTask VIEW
     * @return VIEW集合
     */
    public List<VTask> selectVTaskList(VTask vTask);

    /**
     * 新增VIEW
     * 
     * @param vTask VIEW
     * @return 结果
     */
    public int insertVTask(VTask vTask);

    /**
     * 修改VIEW
     * 
     * @param vTask VIEW
     * @return 结果
     */
    public int updateVTask(VTask vTask);

    /**
     * 批量删除VIEW
     * 
     * @param taskIds 需要删除的VIEWID
     * @return 结果
     */
    public int deleteVTaskByIds(Long[] taskIds);

    /**
     * 删除VIEW信息
     * 
     * @param taskId VIEWID
     * @return 结果
     */
    public int deleteVTaskById(Long taskId);
}
