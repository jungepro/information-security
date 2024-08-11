package com.ruoyi.custom.service;

import java.util.List;
import com.ruoyi.custom.domain.TShenqin;

/**
 * 申请Service接口
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public interface ITShenqinService 
{
    /**
     * 查询申请
     * 
     * @param id 申请ID
     * @return 申请
     */
    public TShenqin selectTShenqinById(Long id);

    /**
     * 查询申请列表
     * 
     * @param tShenqin 申请
     * @return 申请集合
     */
    public List<TShenqin> selectTShenqinList(TShenqin tShenqin);

    /**
     * 新增申请
     * 
     * @param tShenqin 申请
     * @return 结果
     */
    public int insertTShenqin(TShenqin tShenqin);

    /**
     * 修改申请
     * 
     * @param tShenqin 申请
     * @return 结果
     */
    public int updateTShenqin(TShenqin tShenqin);

    /**
     * 批量删除申请
     * 
     * @param ids 需要删除的申请ID
     * @return 结果
     */
    public int deleteTShenqinByIds(Long[] ids);

    /**
     * 删除申请信息
     * 
     * @param id 申请ID
     * @return 结果
     */
    public int deleteTShenqinById(Long id);
}
