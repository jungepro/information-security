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
import com.ruoyi.temp.domain.TempCategory;
import com.ruoyi.temp.service.ITempCategoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 分类Controller
 * 
 * @author ruoyi
 * @date 2021-11-18
 */
@RestController
@RequestMapping("/temp/category")
public class TempCategoryController extends BaseController
{
    private static final Logger logger = LoggerFactory.getLogger(TempCategoryController.class);

    @Autowired
    private ITempCategoryService tempCategoryService;

    /**
     * 查询分类列表
     */
    @PreAuthorize("@ss.hasPermi('temp:category:list')")
    @GetMapping("/list")
    public TableDataInfo list(TempCategory tempCategory)
    {
        startPage();
        List<TempCategory> list = tempCategoryService.selectTempCategoryList(tempCategory);
        return getDataTable(list);
    }

    /**
     * 导出分类列表
     */
    @PreAuthorize("@ss.hasPermi('temp:category:export')")
    @Log(title = "分类", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TempCategory tempCategory)
    {
        List<TempCategory> list = tempCategoryService.selectTempCategoryList(tempCategory);
        ExcelUtil<TempCategory> util = new ExcelUtil<TempCategory>(TempCategory.class);
        return util.exportExcel(list, "category");
    }

    /**
     * 获取分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('temp:category:query')")
    @GetMapping(value = "/{categoryId}")
    public AjaxResult getInfo(@PathVariable("categoryId") Long categoryId)
    {
        return AjaxResult.success(tempCategoryService.selectTempCategoryById(categoryId));
    }

    /**
     * 新增分类
     */
    @PreAuthorize("@ss.hasPermi('temp:category:add')")
    @Log(title = "分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TempCategory tempCategory)
    {
        return toAjax(tempCategoryService.insertTempCategory(tempCategory));
    }

    /**
     * 修改分类
     */
    @PreAuthorize("@ss.hasPermi('temp:category:edit')")
    @Log(title = "分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TempCategory tempCategory)
    {
        return toAjax(tempCategoryService.updateTempCategory(tempCategory));
    }

    /**
     * 删除分类
     */
    @PreAuthorize("@ss.hasPermi('temp:category:remove')")
    @Log(title = "分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{categoryIds}")
    public AjaxResult remove(@PathVariable Long[] categoryIds)
    {
        return toAjax(tempCategoryService.deleteTempCategoryByIds(categoryIds));
    }
}
