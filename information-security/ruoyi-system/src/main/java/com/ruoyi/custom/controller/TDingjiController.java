package com.ruoyi.custom.controller;

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
import com.ruoyi.custom.mapper.TDingjiMapper;
import com.ruoyi.custom.domain.TDingji;
import com.ruoyi.custom.service.ITDingjiService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 定级Controller
 * 
 * @author ruoyi
 * @date 2023-05-21
 */
@RestController
@RequestMapping("/custom/dingji")
public class TDingjiController extends BaseController
{
    private static final Logger logger = LoggerFactory.getLogger(TDingjiController.class);

    @Autowired
    private ITDingjiService tDingjiService;

    @Autowired
    private TDingjiMapper tDingjiMapper;

    /**
     * 查询定级列表
     */
    @PreAuthorize("@ss.hasPermi('custom:dingji:list')")
    @GetMapping("/list")
    public TableDataInfo list(TDingji tDingji)
    {
        startPage();
        List<TDingji> list = tDingjiService.selectTDingjiList(tDingji);
        return getDataTable(list);
    }

    /**
     * 导出定级列表
     */
    @PreAuthorize("@ss.hasPermi('custom:dingji:export')")
    @Log(title = "定级", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TDingji tDingji)
    {
        List<TDingji> list = tDingjiService.selectTDingjiList(tDingji);
        ExcelUtil<TDingji> util = new ExcelUtil<TDingji>(TDingji.class);
        return util.exportExcel(list, "dingji");
    }

    /**
     * 获取定级详细信息
     */
    @PreAuthorize("@ss.hasPermi('custom:dingji:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tDingjiService.selectTDingjiById(id));
    }

    /**
     * 新增定级
     */
    @PreAuthorize("@ss.hasPermi('custom:dingji:add')")
    @Log(title = "定级", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TDingji tDingji)
    {
        return toAjax(tDingjiService.insertTDingji(tDingji));
    }

    /**
     * 修改定级
     */
    @PreAuthorize("@ss.hasPermi('custom:dingji:edit')")
    @Log(title = "定级", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TDingji tDingji)
    {
        return toAjax(tDingjiService.updateTDingji(tDingji));
    }

    /**
     * 删除定级
     */
    @PreAuthorize("@ss.hasPermi('custom:dingji:remove')")
    @Log(title = "定级", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tDingjiService.deleteTDingjiByIds(ids));
    }

    /**
     * 自定义sql定级查询
     */
    @GetMapping("/customTDingjiSql")
    public AjaxResult customTDingjiSql(TDingji tDingji) {
        return AjaxResult.success(tDingjiMapper.customTDingjiSql(tDingji));
    }
}
