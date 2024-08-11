package com.ruoyi.custom.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.custom.mapper.TShenqinMapper;
import com.ruoyi.custom.domain.TShenqin;
import com.ruoyi.custom.service.ITShenqinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 申请Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@Service
public class TShenqinServiceImpl implements ITShenqinService 
{
    private static final Logger logger = LoggerFactory.getLogger(TShenqinServiceImpl.class);

    @Autowired
    private TShenqinMapper tShenqinMapper;

    /**
     * 查询申请
     * 
     * @param id 申请ID
     * @return 申请
     */
    @Override
    public TShenqin selectTShenqinById(Long id)
    {
        return tShenqinMapper.selectTShenqinById(id);
    }

    /**
     * 查询申请列表
     * 
     * @param tShenqin 申请
     * @return 申请
     */
    @Override
    public List<TShenqin> selectTShenqinList(TShenqin tShenqin)
    {
        return tShenqinMapper.selectTShenqinList(tShenqin);
    }

    /**
     * 新增申请
     * 
     * @param tShenqin 申请
     * @return 结果
     */
    @Override
    public int insertTShenqin(TShenqin tShenqin)
    {
        tShenqin.setCreateTime(DateUtils.getNowDate());
        return tShenqinMapper.insertTShenqin(tShenqin);
    }

    /**
     * 修改申请
     * 
     * @param tShenqin 申请
     * @return 结果
     */
    @Override
    public int updateTShenqin(TShenqin tShenqin)
    {
        tShenqin.setUpdateTime(DateUtils.getNowDate());
        return tShenqinMapper.updateTShenqin(tShenqin);
    }

    /**
     * 批量删除申请
     * 
     * @param ids 需要删除的申请ID
     * @return 结果
     */
    @Override
    public int deleteTShenqinByIds(Long[] ids)
    {
        return tShenqinMapper.deleteTShenqinByIds(ids);
    }

    /**
     * 删除申请信息
     * 
     * @param id 申请ID
     * @return 结果
     */
    @Override
    public int deleteTShenqinById(Long id)
    {
        return tShenqinMapper.deleteTShenqinById(id);
    }
}
