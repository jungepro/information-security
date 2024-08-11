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
import com.ruoyi.custom.mapper.TNoticeMapper;
import com.ruoyi.custom.domain.TNotice;
import com.ruoyi.custom.service.ITNoticeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 系统公告Controller
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
@RestController
@RequestMapping("/custom/notice")
public class TNoticeController extends BaseController
{
    private static final Logger logger = LoggerFactory.getLogger(TNoticeController.class);

    @Autowired
    private ITNoticeService tNoticeService;

    @Autowired
    private TNoticeMapper tNoticeMapper;

    /**
     * 查询系统公告列表
     */
    @PreAuthorize("@ss.hasPermi('custom:notice:list')")
    @GetMapping("/list")
    public TableDataInfo list(TNotice tNotice)
    {
        startPage();
        List<TNotice> list = tNoticeService.selectTNoticeList(tNotice);
        return getDataTable(list);
    }

    /**
     * 导出系统公告列表
     */
    @PreAuthorize("@ss.hasPermi('custom:notice:export')")
    @Log(title = "系统公告", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TNotice tNotice)
    {
        List<TNotice> list = tNoticeService.selectTNoticeList(tNotice);
        ExcelUtil<TNotice> util = new ExcelUtil<TNotice>(TNotice.class);
        return util.exportExcel(list, "notice");
    }

    /**
     * 获取系统公告详细信息
     */
    @PreAuthorize("@ss.hasPermi('custom:notice:query')")
    @GetMapping(value = "/{noticeId}")
    public AjaxResult getInfo(@PathVariable("noticeId") Long noticeId)
    {
        return AjaxResult.success(tNoticeService.selectTNoticeById(noticeId));
    }

    /**
     * 新增系统公告
     */
    @PreAuthorize("@ss.hasPermi('custom:notice:add')")
    @Log(title = "系统公告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TNotice tNotice)
    {
        return toAjax(tNoticeService.insertTNotice(tNotice));
    }

    /**
     * 修改系统公告
     */
    @PreAuthorize("@ss.hasPermi('custom:notice:edit')")
    @Log(title = "系统公告", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TNotice tNotice)
    {
        return toAjax(tNoticeService.updateTNotice(tNotice));
    }

    /**
     * 删除系统公告
     */
    @PreAuthorize("@ss.hasPermi('custom:notice:remove')")
    @Log(title = "系统公告", businessType = BusinessType.DELETE)
	@DeleteMapping("/{noticeIds}")
    public AjaxResult remove(@PathVariable Long[] noticeIds)
    {
        return toAjax(tNoticeService.deleteTNoticeByIds(noticeIds));
    }

    /**
     * 自定义sql系统公告查询
     */
    @GetMapping("/customTNoticeSql")
    public AjaxResult customTNoticeSql(TNotice tNotice) {
        return AjaxResult.success(tNoticeMapper.customTNoticeSql(tNotice));
    }
}
