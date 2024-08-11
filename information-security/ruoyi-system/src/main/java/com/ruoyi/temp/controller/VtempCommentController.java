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
import com.ruoyi.temp.domain.VtempComment;
import com.ruoyi.temp.service.IVtempCommentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * VIEWController
 * 
 * @author ruoyi
 * @date 2021-11-18
 */
@RestController
@RequestMapping("/vtemp/comment")
public class VtempCommentController extends BaseController
{
    private static final Logger logger = LoggerFactory.getLogger(VtempCommentController.class);

    @Autowired
    private IVtempCommentService vtempCommentService;

    /**
     * 查询VIEW列表
     */
    @PreAuthorize("@ss.hasPermi('temp:comment:list')")
    @GetMapping("/list")
    public TableDataInfo list(VtempComment vtempComment)
    {
        startPage();
        List<VtempComment> list = vtempCommentService.selectVtempCommentList(vtempComment);
        return getDataTable(list);
    }

    /**
     * 导出VIEW列表
     */
    @PreAuthorize("@ss.hasPermi('temp:comment:export')")
    @Log(title = "VIEW", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(VtempComment vtempComment)
    {
        List<VtempComment> list = vtempCommentService.selectVtempCommentList(vtempComment);
        ExcelUtil<VtempComment> util = new ExcelUtil<VtempComment>(VtempComment.class);
        return util.exportExcel(list, "comment");
    }

    /**
     * 获取VIEW详细信息
     */
    @PreAuthorize("@ss.hasPermi('temp:comment:query')")
    @GetMapping(value = "/{commentId}")
    public AjaxResult getInfo(@PathVariable("commentId") Long commentId)
    {
        return AjaxResult.success(vtempCommentService.selectVtempCommentById(commentId));
    }

    /**
     * 新增VIEW
     */
    @PreAuthorize("@ss.hasPermi('temp:comment:add')")
    @Log(title = "VIEW", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VtempComment vtempComment)
    {
        return toAjax(vtempCommentService.insertVtempComment(vtempComment));
    }

    /**
     * 修改VIEW
     */
    @PreAuthorize("@ss.hasPermi('temp:comment:edit')")
    @Log(title = "VIEW", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VtempComment vtempComment)
    {
        return toAjax(vtempCommentService.updateVtempComment(vtempComment));
    }

    /**
     * 删除VIEW
     */
    @PreAuthorize("@ss.hasPermi('temp:comment:remove')")
    @Log(title = "VIEW", businessType = BusinessType.DELETE)
	@DeleteMapping("/{commentIds}")
    public AjaxResult remove(@PathVariable Long[] commentIds)
    {
        return toAjax(vtempCommentService.deleteVtempCommentByIds(commentIds));
    }
}
