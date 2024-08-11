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
import com.ruoyi.custom.mapper.TFileMapper;
import com.ruoyi.custom.domain.TFile;
import com.ruoyi.custom.service.ITFileService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 操作手册Controller
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
@RestController
@RequestMapping("/custom/file")
public class TFileController extends BaseController
{
    private static final Logger logger = LoggerFactory.getLogger(TFileController.class);

    @Autowired
    private ITFileService tFileService;

    @Autowired
    private TFileMapper tFileMapper;

    /**
     * 查询操作手册列表
     */
    @PreAuthorize("@ss.hasPermi('custom:file:list')")
    @GetMapping("/list")
    public TableDataInfo list(TFile tFile)
    {
        startPage();
        List<TFile> list = tFileService.selectTFileList(tFile);
        return getDataTable(list);
    }

    /**
     * 导出操作手册列表
     */
    @PreAuthorize("@ss.hasPermi('custom:file:export')")
    @Log(title = "操作手册", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TFile tFile)
    {
        List<TFile> list = tFileService.selectTFileList(tFile);
        ExcelUtil<TFile> util = new ExcelUtil<TFile>(TFile.class);
        return util.exportExcel(list, "file");
    }

    /**
     * 获取操作手册详细信息
     */
    @PreAuthorize("@ss.hasPermi('custom:file:query')")
    @GetMapping(value = "/{fileId}")
    public AjaxResult getInfo(@PathVariable("fileId") Long fileId)
    {
        return AjaxResult.success(tFileService.selectTFileById(fileId));
    }

    /**
     * 新增操作手册
     */
    @PreAuthorize("@ss.hasPermi('custom:file:add')")
    @Log(title = "操作手册", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TFile tFile)
    {
        return toAjax(tFileService.insertTFile(tFile));
    }

    /**
     * 修改操作手册
     */
    @PreAuthorize("@ss.hasPermi('custom:file:edit')")
    @Log(title = "操作手册", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TFile tFile)
    {
        return toAjax(tFileService.updateTFile(tFile));
    }

    /**
     * 删除操作手册
     */
    @PreAuthorize("@ss.hasPermi('custom:file:remove')")
    @Log(title = "操作手册", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fileIds}")
    public AjaxResult remove(@PathVariable Long[] fileIds)
    {
        return toAjax(tFileService.deleteTFileByIds(fileIds));
    }

    /**
     * 自定义sql操作手册查询
     */
    @GetMapping("/customTFileSql")
    public AjaxResult customTFileSql(TFile tFile) {
        return AjaxResult.success(tFileMapper.customTFileSql(tFile));
    }
}
