package com.ruoyi.temp.mapper;

import java.util.List;
import com.ruoyi.temp.domain.TempCategory;

/**
 * 分类Mapper接口
 * 
 * @author ruoyi
 * @date 2021-11-18
 */
public interface TempCategoryMapper 
{
    /**
     * 查询分类
     * 
     * @param categoryId 分类ID
     * @return 分类
     */
    public TempCategory selectTempCategoryById(Long categoryId);

    /**
     * 查询分类列表
     * 
     * @param tempCategory 分类
     * @return 分类集合
     */
    public List<TempCategory> selectTempCategoryList(TempCategory tempCategory);

    /**
     * 新增分类
     * 
     * @param tempCategory 分类
     * @return 结果
     */
    public int insertTempCategory(TempCategory tempCategory);

    /**
     * 修改分类
     * 
     * @param tempCategory 分类
     * @return 结果
     */
    public int updateTempCategory(TempCategory tempCategory);

    /**
     * 删除分类
     * 
     * @param categoryId 分类ID
     * @return 结果
     */
    public int deleteTempCategoryById(Long categoryId);

    /**
     * 批量删除分类
     * 
     * @param categoryIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTempCategoryByIds(Long[] categoryIds);
}
