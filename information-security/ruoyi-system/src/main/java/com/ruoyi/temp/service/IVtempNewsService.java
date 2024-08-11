package com.ruoyi.temp.service;

import java.util.List;
import com.ruoyi.temp.domain.VtempNews;

/**
 * VIEWService接口
 * 
 * @author ruoyi
 * @date 2021-11-18
 */
public interface IVtempNewsService 
{
    /**
     * 查询VIEW
     * 
     * @param newsId VIEWID
     * @return VIEW
     */
    public VtempNews selectVtempNewsById(Long newsId);

    /**
     * 查询VIEW列表
     * 
     * @param vtempNews VIEW
     * @return VIEW集合
     */
    public List<VtempNews> selectVtempNewsList(VtempNews vtempNews);

    /**
     * 新增VIEW
     * 
     * @param vtempNews VIEW
     * @return 结果
     */
    public int insertVtempNews(VtempNews vtempNews);

    /**
     * 修改VIEW
     * 
     * @param vtempNews VIEW
     * @return 结果
     */
    public int updateVtempNews(VtempNews vtempNews);

    /**
     * 批量删除VIEW
     * 
     * @param newsIds 需要删除的VIEWID
     * @return 结果
     */
    public int deleteVtempNewsByIds(Long[] newsIds);

    /**
     * 删除VIEW信息
     * 
     * @param newsId VIEWID
     * @return 结果
     */
    public int deleteVtempNewsById(Long newsId);
}
