package com.ruoyi.custom.service;

import java.util.List;
import com.ruoyi.custom.domain.VOperate;

/**
 * VIEWService接口
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
public interface IVOperateService 
{
    /**
     * 查询VIEW
     * 
     * @param operateId VIEWID
     * @return VIEW
     */
    public VOperate selectVOperateById(Long operateId);

    /**
     * 查询VIEW列表
     * 
     * @param vOperate VIEW
     * @return VIEW集合
     */
    public List<VOperate> selectVOperateList(VOperate vOperate);

    /**
     * 新增VIEW
     * 
     * @param vOperate VIEW
     * @return 结果
     */
    public int insertVOperate(VOperate vOperate);

    /**
     * 修改VIEW
     * 
     * @param vOperate VIEW
     * @return 结果
     */
    public int updateVOperate(VOperate vOperate);

    /**
     * 批量删除VIEW
     * 
     * @param operateIds 需要删除的VIEWID
     * @return 结果
     */
    public int deleteVOperateByIds(Long[] operateIds);

    /**
     * 删除VIEW信息
     * 
     * @param operateId VIEWID
     * @return 结果
     */
    public int deleteVOperateById(Long operateId);
}
