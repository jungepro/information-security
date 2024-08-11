package com.ruoyi.temp.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.temp.mapper.VtempNewsMapper;
import com.ruoyi.temp.domain.VtempNews;
import com.ruoyi.temp.service.IVtempNewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * VIEWService业务层处理
 * 
 * @author ruoyi
 * @date 2021-11-18
 */
@Service
public class VtempNewsServiceImpl implements IVtempNewsService 
{
    private static final Logger logger = LoggerFactory.getLogger(VtempNewsServiceImpl.class);

    @Autowired
    private VtempNewsMapper vtempNewsMapper;

    /**
     * 查询VIEW
     * 
     * @param newsId VIEWID
     * @return VIEW
     */
    @Override
    public VtempNews selectVtempNewsById(Long newsId)
    {
        return vtempNewsMapper.selectVtempNewsById(newsId);
    }

    /**
     * 查询VIEW列表
     * 
     * @param vtempNews VIEW
     * @return VIEW
     */
    @Override
    public List<VtempNews> selectVtempNewsList(VtempNews vtempNews)
    {
        return vtempNewsMapper.selectVtempNewsList(vtempNews);
    }

    /**
     * 新增VIEW
     * 
     * @param vtempNews VIEW
     * @return 结果
     */
    @Override
    public int insertVtempNews(VtempNews vtempNews)
    {
        return vtempNewsMapper.insertVtempNews(vtempNews);
    }

    /**
     * 修改VIEW
     * 
     * @param vtempNews VIEW
     * @return 结果
     */
    @Override
    public int updateVtempNews(VtempNews vtempNews)
    {
        return vtempNewsMapper.updateVtempNews(vtempNews);
    }

    /**
     * 批量删除VIEW
     * 
     * @param newsIds 需要删除的VIEWID
     * @return 结果
     */
    @Override
    public int deleteVtempNewsByIds(Long[] newsIds)
    {
        return vtempNewsMapper.deleteVtempNewsByIds(newsIds);
    }

    /**
     * 删除VIEW信息
     * 
     * @param newsId VIEWID
     * @return 结果
     */
    @Override
    public int deleteVtempNewsById(Long newsId)
    {
        return vtempNewsMapper.deleteVtempNewsById(newsId);
    }
}
