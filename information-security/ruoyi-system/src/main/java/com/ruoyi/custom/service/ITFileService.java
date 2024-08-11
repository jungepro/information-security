package com.ruoyi.custom.service;

import java.util.List;
import com.ruoyi.custom.domain.TFile;

/**
 * 操作手册Service接口
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
public interface ITFileService 
{
    /**
     * 查询操作手册
     * 
     * @param fileId 操作手册ID
     * @return 操作手册
     */
    public TFile selectTFileById(Long fileId);

    /**
     * 查询操作手册列表
     * 
     * @param tFile 操作手册
     * @return 操作手册集合
     */
    public List<TFile> selectTFileList(TFile tFile);

    /**
     * 新增操作手册
     * 
     * @param tFile 操作手册
     * @return 结果
     */
    public int insertTFile(TFile tFile);

    /**
     * 修改操作手册
     * 
     * @param tFile 操作手册
     * @return 结果
     */
    public int updateTFile(TFile tFile);

    /**
     * 批量删除操作手册
     * 
     * @param fileIds 需要删除的操作手册ID
     * @return 结果
     */
    public int deleteTFileByIds(Long[] fileIds);

    /**
     * 删除操作手册信息
     * 
     * @param fileId 操作手册ID
     * @return 结果
     */
    public int deleteTFileById(Long fileId);
}
