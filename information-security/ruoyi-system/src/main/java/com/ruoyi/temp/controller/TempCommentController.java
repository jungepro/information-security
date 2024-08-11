package com.ruoyi.temp.controller;

import java.util.List;

import com.ruoyi.common.utils.SecurityUtils;
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
import com.ruoyi.temp.domain.TempComment;
import com.ruoyi.temp.service.ITempCommentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 评论Controller
 * 
 * @author ruoyi
 * @date 2021-11-18
 */
@RestController
@RequestMapping("/temp/comment")
public class TempCommentController extends BaseController
{
    private static final Logger logger = LoggerFactory.getLogger(TempCommentController.class);

    @Autowired
    private ITempCommentService tempCommentService;

    /**
     * 查询评论列表
     */
    @PreAuthorize("@ss.hasPermi('temp:comment:list')")
    @GetMapping("/list")
    public TableDataInfo list(TempComment tempComment)
    {
        startPage();
        List<TempComment> list = tempCommentService.selectTempCommentList(tempComment);
        return getDataTable(list);
    }

    /**
     * 导出评论列表
     */
    @PreAuthorize("@ss.hasPermi('temp:comment:export')")
    @Log(title = "评论", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TempComment tempComment)
    {
        List<TempComment> list = tempCommentService.selectTempCommentList(tempComment);
        ExcelUtil<TempComment> util = new ExcelUtil<TempComment>(TempComment.class);
        return util.exportExcel(list, "comment");
    }

    /**
     * 获取评论详细信息
     */
    @PreAuthorize("@ss.hasPermi('temp:comment:query')")
    @GetMapping(value = "/{commentId}")
    public AjaxResult getInfo(@PathVariable("commentId") Long commentId)
    {
        return AjaxResult.success(tempCommentService.selectTempCommentById(commentId));
    }

    /**
     * 新增评论
     */
    @PreAuthorize("@ss.hasPermi('temp:comment:add')")
    @Log(title = "评论", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TempComment tempComment)
    {
        tempComment.setUserId(SecurityUtils.getLoginUser().getUser().getUserId());
        return toAjax(tempCommentService.insertTempComment(tempComment));
    }

    /**
     * 修改评论
     */
    @PreAuthorize("@ss.hasPermi('temp:comment:edit')")
    @Log(title = "评论", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TempComment tempComment)
    {
        return toAjax(tempCommentService.updateTempComment(tempComment));
    }

    /**
     * 删除评论
     */
    @PreAuthorize("@ss.hasPermi('temp:comment:remove')")
    @Log(title = "评论", businessType = BusinessType.DELETE)
	@DeleteMapping("/{commentIds}")
    public AjaxResult remove(@PathVariable Long[] commentIds)
    {
        return toAjax(tempCommentService.deleteTempCommentByIds(commentIds));
    }
}
