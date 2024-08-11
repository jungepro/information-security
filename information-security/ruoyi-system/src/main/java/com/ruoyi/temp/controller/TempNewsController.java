package com.ruoyi.temp.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ruoyi.temp.domain.TempNews;
import com.ruoyi.temp.service.ITempNewsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 新闻Controller
 * 
 * @author ruoyi
 * @date 2021-11-18
 */
@RestController
@RequestMapping("/temp/news")
public class TempNewsController extends BaseController
{
    private static final Logger logger = LoggerFactory.getLogger(TempNewsController.class);

    @Autowired
    private ITempNewsService tempNewsService;

    /**
     * 查询新闻列表
     */
    @PreAuthorize("@ss.hasPermi('temp:news:list')")
    @GetMapping("/list")
    public TableDataInfo list(TempNews tempNews)
    {
        startPage();
        List<TempNews> list = tempNewsService.selectTempNewsList(tempNews);
        return getDataTable(list);
    }

    /**
     * 导出新闻列表
     */
    @PreAuthorize("@ss.hasPermi('temp:news:export')")
    @Log(title = "新闻", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TempNews tempNews)
    {
        List<TempNews> list = tempNewsService.selectTempNewsList(tempNews);
        ExcelUtil<TempNews> util = new ExcelUtil<TempNews>(TempNews.class);
        return util.exportExcel(list, "news");
    }

    /**
     * 获取新闻详细信息
     */
    @PreAuthorize("@ss.hasPermi('temp:news:query')")
    @GetMapping(value = "/{newsId}")
    public AjaxResult getInfo(@PathVariable("newsId") Long newsId)
    {
        return AjaxResult.success(tempNewsService.selectTempNewsById(newsId));
    }

    /**
     * 新增新闻
     */
    @PreAuthorize("@ss.hasPermi('temp:news:add')")
    @Log(title = "新闻", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TempNews tempNews)
    {
        return toAjax(tempNewsService.insertTempNews(tempNews));
    }

    /**
     * 修改新闻
     */
    @PreAuthorize("@ss.hasPermi('temp:news:edit')")
    @Log(title = "新闻", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TempNews tempNews)
    {
        return toAjax(tempNewsService.updateTempNews(tempNews));
    }

    /**
     * 删除新闻
     */
    @PreAuthorize("@ss.hasPermi('temp:news:remove')")
    @Log(title = "新闻", businessType = BusinessType.DELETE)
	@DeleteMapping("/{newsIds}")
    public AjaxResult remove(@PathVariable Long[] newsIds)
    {
        return toAjax(tempNewsService.deleteTempNewsByIds(newsIds));
    }
}
