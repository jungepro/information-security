package com.ruoyi.custom.controller;

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
import com.ruoyi.custom.mapper.TTaskMapper;
import com.ruoyi.custom.domain.TTask;
import com.ruoyi.custom.service.ITTaskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 运维事项Controller
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
@RestController
@RequestMapping("/custom/task")
public class TTaskController extends BaseController
{
    private static final Logger logger = LoggerFactory.getLogger(TTaskController.class);

    @Autowired
    private ITTaskService tTaskService;

    @Autowired
    private TTaskMapper tTaskMapper;

    /**
     * 查询运维事项列表
     */
    @PreAuthorize("@ss.hasPermi('custom:task:list')")
    @GetMapping("/list")
    public TableDataInfo list(TTask tTask)
    {
        startPage();
        List<TTask> list = tTaskService.selectTTaskList(tTask);
        return getDataTable(list);
    }

    /**
     * 导出运维事项列表
     */
    @PreAuthorize("@ss.hasPermi('custom:task:export')")
    @Log(title = "运维事项", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TTask tTask)
    {
        List<TTask> list = tTaskService.selectTTaskList(tTask);
        ExcelUtil<TTask> util = new ExcelUtil<TTask>(TTask.class);
        return util.exportExcel(list, "task");
    }

    /**
     * 获取运维事项详细信息
     */
    @PreAuthorize("@ss.hasPermi('custom:task:query')")
    @GetMapping(value = "/{taskId}")
    public AjaxResult getInfo(@PathVariable("taskId") Long taskId)
    {
        return AjaxResult.success(tTaskService.selectTTaskById(taskId));
    }

    /**
     * 新增运维事项
     */
    @PreAuthorize("@ss.hasPermi('custom:task:add')")
    @Log(title = "运维事项", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TTask tTask)
    {
        tTask.setUserId(SecurityUtils.getLoginUser().getUser().getUserId());
        tTask.setStatus("0");
        return toAjax(tTaskService.insertTTask(tTask));
    }

    /**
     * 修改运维事项
     */
    @PreAuthorize("@ss.hasPermi('custom:task:edit')")
    @Log(title = "运维事项", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TTask tTask)
    {
        return toAjax(tTaskService.updateTTask(tTask));
    }

    /**
     * 删除运维事项
     */
    @PreAuthorize("@ss.hasPermi('custom:task:remove')")
    @Log(title = "运维事项", businessType = BusinessType.DELETE)
	@DeleteMapping("/{taskIds}")
    public AjaxResult remove(@PathVariable Long[] taskIds)
    {
        return toAjax(tTaskService.deleteTTaskByIds(taskIds));
    }

    /**
     * 自定义sql运维事项查询
     */
    @GetMapping("/customTTaskSql")
    public AjaxResult customTTaskSql(TTask tTask) {
        return AjaxResult.success(tTaskMapper.customTTaskSql(tTask));
    }
}
