package com.ruoyi.temp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.temp.mapper.TempNewsMapper;
import com.ruoyi.temp.domain.TempNews;
import com.ruoyi.temp.service.ITempNewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 新闻Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-11-18
 */
@Service
public class TempNewsServiceImpl implements ITempNewsService 
{
    private static final Logger logger = LoggerFactory.getLogger(TempNewsServiceImpl.class);

    @Autowired
    private TempNewsMapper tempNewsMapper;

    /**
     * 查询新闻
     * 
     * @param newsId 新闻ID
     * @return 新闻
     */
    @Override
    public TempNews selectTempNewsById(Long newsId)
    {
        return tempNewsMapper.selectTempNewsById(newsId);
    }

    /**
     * 查询新闻列表
     * 
     * @param tempNews 新闻
     * @return 新闻
     */
    @Override
    public List<TempNews> selectTempNewsList(TempNews tempNews)
    {
        return tempNewsMapper.selectTempNewsList(tempNews);
    }

    /**
     * 新增新闻
     * 
     * @param tempNews 新闻
     * @return 结果
     */
    @Override
    public int insertTempNews(TempNews tempNews)
    {
        return tempNewsMapper.insertTempNews(tempNews);
    }

    /**
     * 修改新闻
     * 
     * @param tempNews 新闻
     * @return 结果
     */
    @Override
    public int updateTempNews(TempNews tempNews)
    {
        return tempNewsMapper.updateTempNews(tempNews);
    }

    /**
     * 批量删除新闻
     * 
     * @param newsIds 需要删除的新闻ID
     * @return 结果
     */
    @Override
    public int deleteTempNewsByIds(Long[] newsIds)
    {
        return tempNewsMapper.deleteTempNewsByIds(newsIds);
    }

    /**
     * 删除新闻信息
     * 
     * @param newsId 新闻ID
     * @return 结果
     */
    @Override
    public int deleteTempNewsById(Long newsId)
    {
        return tempNewsMapper.deleteTempNewsById(newsId);
    }
}
