package com.ruoyi.custom.mapper;

import java.util.List;
import com.ruoyi.custom.domain.VOperate;

/**
 * VIEWMapper接口
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
public interface VOperateMapper 
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
     * 删除VIEW
     * 
     * @param operateId VIEWID
     * @return 结果
     */
    public int deleteVOperateById(Long operateId);

    /**
     * 批量删除VIEW
     * 
     * @param operateIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteVOperateByIds(Long[] operateIds);

    /**
     * 自定义sqlVIEW查询
     */
    public List customVOperateSql(VOperate vOperate);
}
