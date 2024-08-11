package com.ruoyi.temp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.temp.mapper.TempCategoryMapper;
import com.ruoyi.temp.domain.TempCategory;
import com.ruoyi.temp.service.ITempCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 分类Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-11-18
 */
@Service
public class TempCategoryServiceImpl implements ITempCategoryService 
{
    private static final Logger logger = LoggerFactory.getLogger(TempCategoryServiceImpl.class);

    @Autowired
    private TempCategoryMapper tempCategoryMapper;

    /**
     * 查询分类
     * 
     * @param categoryId 分类ID
     * @return 分类
     */
    @Override
    public TempCategory selectTempCategoryById(Long categoryId)
    {
        return tempCategoryMapper.selectTempCategoryById(categoryId);
    }

    /**
     * 查询分类列表
     * 
     * @param tempCategory 分类
     * @return 分类
     */
    @Override
    public List<TempCategory> selectTempCategoryList(TempCategory tempCategory)
    {
        return tempCategoryMapper.selectTempCategoryList(tempCategory);
    }

    /**
     * 新增分类
     * 
     * @param tempCategory 分类
     * @return 结果
     */
    @Override
    public int insertTempCategory(TempCategory tempCategory)
    {
        return tempCategoryMapper.insertTempCategory(tempCategory);
    }

    /**
     * 修改分类
     * 
     * @param tempCategory 分类
     * @return 结果
     */
    @Override
    public int updateTempCategory(TempCategory tempCategory)
    {
        return tempCategoryMapper.updateTempCategory(tempCategory);
    }

    /**
     * 批量删除分类
     * 
     * @param categoryIds 需要删除的分类ID
     * @return 结果
     */
    @Override
    public int deleteTempCategoryByIds(Long[] categoryIds)
    {
        return tempCategoryMapper.deleteTempCategoryByIds(categoryIds);
    }

    /**
     * 删除分类信息
     * 
     * @param categoryId 分类ID
     * @return 结果
     */
    @Override
    public int deleteTempCategoryById(Long categoryId)
    {
        return tempCategoryMapper.deleteTempCategoryById(categoryId);
    }
}
