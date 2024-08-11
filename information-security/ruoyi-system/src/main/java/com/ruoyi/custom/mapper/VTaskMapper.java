package com.ruoyi.custom.mapper;

import java.util.List;
import com.ruoyi.custom.domain.VTask;

/**
 * VIEWMapper接口
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
public interface VTaskMapper 
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
     * 删除VIEW
     * 
     * @param taskId VIEWID
     * @return 结果
     */
    public int deleteVTaskById(Long taskId);

    /**
     * 批量删除VIEW
     * 
     * @param taskIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteVTaskByIds(Long[] taskIds);

    /**
     * 自定义sqlVIEW查询
     */
    public List customVTaskSql(VTask vTask);
}
