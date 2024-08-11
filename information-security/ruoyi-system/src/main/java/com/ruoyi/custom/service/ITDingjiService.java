package com.ruoyi.custom.service;

import java.util.List;
import com.ruoyi.custom.domain.TDingji;

/**
 * 定级Service接口
 * 
 * @author ruoyi
 * @date 2023-05-21
 */
public interface ITDingjiService 
{
    /**
     * 查询定级
     * 
     * @param id 定级ID
     * @return 定级
     */
    public TDingji selectTDingjiById(Long id);

    /**
     * 查询定级列表
     * 
     * @param tDingji 定级
     * @return 定级集合
     */
    public List<TDingji> selectTDingjiList(TDingji tDingji);

    /**
     * 新增定级
     * 
     * @param tDingji 定级
     * @return 结果
     */
    public int insertTDingji(TDingji tDingji);

    /**
     * 修改定级
     * 
     * @param tDingji 定级
     * @return 结果
     */
    public int updateTDingji(TDingji tDingji);

    /**
     * 批量删除定级
     * 
     * @param ids 需要删除的定级ID
     * @return 结果
     */
    public int deleteTDingjiByIds(Long[] ids);

    /**
     * 删除定级信息
     * 
     * @param id 定级ID
     * @return 结果
     */
    public int deleteTDingjiById(Long id);
}
