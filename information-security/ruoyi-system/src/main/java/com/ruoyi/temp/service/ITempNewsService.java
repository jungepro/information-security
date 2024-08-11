package com.ruoyi.temp.service;

import java.util.List;
import com.ruoyi.temp.domain.TempNews;

/**
 * 新闻Service接口
 * 
 * @author ruoyi
 * @date 2021-11-18
 */
public interface ITempNewsService 
{
    /**
     * 查询新闻
     * 
     * @param newsId 新闻ID
     * @return 新闻
     */
    public TempNews selectTempNewsById(Long newsId);

    /**
     * 查询新闻列表
     * 
     * @param tempNews 新闻
     * @return 新闻集合
     */
    public List<TempNews> selectTempNewsList(TempNews tempNews);

    /**
     * 新增新闻
     * 
     * @param tempNews 新闻
     * @return 结果
     */
    public int insertTempNews(TempNews tempNews);

    /**
     * 修改新闻
     * 
     * @param tempNews 新闻
     * @return 结果
     */
    public int updateTempNews(TempNews tempNews);

    /**
     * 批量删除新闻
     * 
     * @param newsIds 需要删除的新闻ID
     * @return 结果
     */
    public int deleteTempNewsByIds(Long[] newsIds);

    /**
     * 删除新闻信息
     * 
     * @param newsId 新闻ID
     * @return 结果
     */
    public int deleteTempNewsById(Long newsId);
}
