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
import com.ruoyi.temp.domain.VtempNews;
import com.ruoyi.temp.service.IVtempNewsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * VIEWController
 * 
 * @author ruoyi
 * @date 2021-11-18
 */
@RestController
@RequestMapping("/vtemp/news")
public class VtempNewsController extends BaseController
{
    private static final Logger logger = LoggerFactory.getLogger(VtempNewsController.class);

    @Autowired
    private IVtempNewsService vtempNewsService;

    /**
     * 查询VIEW列表
     */
    @PreAuthorize("@ss.hasPermi('temp:news:list')")
    @GetMapping("/list")
    public TableDataInfo list(VtempNews vtempNews)
    {
        startPage();
        List<VtempNews> list = vtempNewsService.selectVtempNewsList(vtempNews);
        return getDataTable(list);
    }

    /**
     * 导出VIEW列表
     */
    @PreAuthorize("@ss.hasPermi('temp:news:export')")
    @Log(title = "VIEW", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(VtempNews vtempNews)
    {
        List<VtempNews> list = vtempNewsService.selectVtempNewsList(vtempNews);
        ExcelUtil<VtempNews> util = new ExcelUtil<VtempNews>(VtempNews.class);
        return util.exportExcel(list, "news");
    }

    /**
     * 获取VIEW详细信息
     */
    @PreAuthorize("@ss.hasPermi('temp:news:query')")
    @GetMapping(value = "/{newsId}")
    public AjaxResult getInfo(@PathVariable("newsId") Long newsId)
    {
        return AjaxResult.success(vtempNewsService.selectVtempNewsById(newsId));
    }

    /**
     * 新增VIEW
     */
    @PreAuthorize("@ss.hasPermi('temp:news:add')")
    @Log(title = "VIEW", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VtempNews vtempNews)
    {
        return toAjax(vtempNewsService.insertVtempNews(vtempNews));
    }

    /**
     * 修改VIEW
     */
    @PreAuthorize("@ss.hasPermi('temp:news:edit')")
    @Log(title = "VIEW", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VtempNews vtempNews)
    {
        return toAjax(vtempNewsService.updateVtempNews(vtempNews));
    }

    /**
     * 删除VIEW
     */
    @PreAuthorize("@ss.hasPermi('temp:news:remove')")
    @Log(title = "VIEW", businessType = BusinessType.DELETE)
	@DeleteMapping("/{newsIds}")
    public AjaxResult remove(@PathVariable Long[] newsIds)
    {
        return toAjax(vtempNewsService.deleteVtempNewsByIds(newsIds));
    }
}
