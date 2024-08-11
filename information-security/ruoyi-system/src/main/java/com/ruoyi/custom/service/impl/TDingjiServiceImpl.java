package com.ruoyi.custom.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.custom.mapper.TDingjiMapper;
import com.ruoyi.custom.domain.TDingji;
import com.ruoyi.custom.service.ITDingjiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定级Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-21
 */
@Service
public class TDingjiServiceImpl implements ITDingjiService 
{
    private static final Logger logger = LoggerFactory.getLogger(TDingjiServiceImpl.class);

    @Autowired
    private TDingjiMapper tDingjiMapper;

    /**
     * 查询定级
     * 
     * @param id 定级ID
     * @return 定级
     */
    @Override
    public TDingji selectTDingjiById(Long id)
    {
        return tDingjiMapper.selectTDingjiById(id);
    }

    /**
     * 查询定级列表
     * 
     * @param tDingji 定级
     * @return 定级
     */
    @Override
    public List<TDingji> selectTDingjiList(TDingji tDingji)
    {
        return tDingjiMapper.selectTDingjiList(tDingji);
    }

    /**
     * 新增定级
     * 
     * @param tDingji 定级
     * @return 结果
     */
    @Override
    public int insertTDingji(TDingji tDingji)
    {
        tDingji.setCreateTime(DateUtils.getNowDate());
        return tDingjiMapper.insertTDingji(tDingji);
    }

    /**
     * 修改定级
     * 
     * @param tDingji 定级
     * @return 结果
     */
    @Override
    public int updateTDingji(TDingji tDingji)
    {
        tDingji.setUpdateTime(DateUtils.getNowDate());
        return tDingjiMapper.updateTDingji(tDingji);
    }

    /**
     * 批量删除定级
     * 
     * @param ids 需要删除的定级ID
     * @return 结果
     */
    @Override
    public int deleteTDingjiByIds(Long[] ids)
    {
        return tDingjiMapper.deleteTDingjiByIds(ids);
    }

    /**
     * 删除定级信息
     * 
     * @param id 定级ID
     * @return 结果
     */
    @Override
    public int deleteTDingjiById(Long id)
    {
        return tDingjiMapper.deleteTDingjiById(id);
    }
}
