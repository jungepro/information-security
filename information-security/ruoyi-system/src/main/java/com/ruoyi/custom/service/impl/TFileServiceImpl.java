package com.ruoyi.custom.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.custom.mapper.TFileMapper;
import com.ruoyi.custom.domain.TFile;
import com.ruoyi.custom.service.ITFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 操作手册Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
@Service
public class TFileServiceImpl implements ITFileService 
{
    private static final Logger logger = LoggerFactory.getLogger(TFileServiceImpl.class);

    @Autowired
    private TFileMapper tFileMapper;

    /**
     * 查询操作手册
     * 
     * @param fileId 操作手册ID
     * @return 操作手册
     */
    @Override
    public TFile selectTFileById(Long fileId)
    {
        return tFileMapper.selectTFileById(fileId);
    }

    /**
     * 查询操作手册列表
     * 
     * @param tFile 操作手册
     * @return 操作手册
     */
    @Override
    public List<TFile> selectTFileList(TFile tFile)
    {
        return tFileMapper.selectTFileList(tFile);
    }

    /**
     * 新增操作手册
     * 
     * @param tFile 操作手册
     * @return 结果
     */
    @Override
    public int insertTFile(TFile tFile)
    {
        tFile.setCreateTime(DateUtils.getNowDate());
        return tFileMapper.insertTFile(tFile);
    }

    /**
     * 修改操作手册
     * 
     * @param tFile 操作手册
     * @return 结果
     */
    @Override
    public int updateTFile(TFile tFile)
    {
        tFile.setUpdateTime(DateUtils.getNowDate());
        return tFileMapper.updateTFile(tFile);
    }

    /**
     * 批量删除操作手册
     * 
     * @param fileIds 需要删除的操作手册ID
     * @return 结果
     */
    @Override
    public int deleteTFileByIds(Long[] fileIds)
    {
        return tFileMapper.deleteTFileByIds(fileIds);
    }

    /**
     * 删除操作手册信息
     * 
     * @param fileId 操作手册ID
     * @return 结果
     */
    @Override
    public int deleteTFileById(Long fileId)
    {
        return tFileMapper.deleteTFileById(fileId);
    }
}
