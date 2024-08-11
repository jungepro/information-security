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
import com.ruoyi.custom.mapper.VTaskMapper;
import com.ruoyi.custom.domain.VTask;
import com.ruoyi.custom.service.IVTaskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * VIEWController
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
@RestController
@RequestMapping("/v_custom/task")
public class VTaskController extends BaseController
{
    private static final Logger logger = LoggerFactory.getLogger(VTaskController.class);

    @Autowired
    private IVTaskService vTaskService;

    @Autowired
    private VTaskMapper vTaskMapper;

    /**
     * 查询VIEW列表
     */
    @PreAuthorize("@ss.hasPermi('custom:task:list')")
    @GetMapping("/list")
    public TableDataInfo list(VTask vTask)
    {
        startPage();
        List<VTask> list = vTaskService.selectVTaskList(vTask);
        return getDataTable(list);
    }

    /**
     * 导出VIEW列表
     */
    @PreAuthorize("@ss.hasPermi('custom:task:export')")
    @Log(title = "VIEW", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(VTask vTask)
    {
        List<VTask> list = vTaskService.selectVTaskList(vTask);
        ExcelUtil<VTask> util = new ExcelUtil<VTask>(VTask.class);
        return util.exportExcel(list, "task");
    }

    /**
     * 获取VIEW详细信息
     */
    @PreAuthorize("@ss.hasPermi('custom:task:query')")
    @GetMapping(value = "/{taskId}")
    public AjaxResult getInfo(@PathVariable("taskId") Long taskId)
    {
        return AjaxResult.success(vTaskService.selectVTaskById(taskId));
    }

    /**
     * 新增VIEW
     */
    @PreAuthorize("@ss.hasPermi('custom:task:add')")
    @Log(title = "VIEW", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VTask vTask)
    {
        return toAjax(vTaskService.insertVTask(vTask));
    }

    /**
     * 修改VIEW
     */
    @PreAuthorize("@ss.hasPermi('custom:task:edit')")
    @Log(title = "VIEW", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VTask vTask)
    {
        return toAjax(vTaskService.updateVTask(vTask));
    }

    /**
     * 删除VIEW
     */
    @PreAuthorize("@ss.hasPermi('custom:task:remove')")
    @Log(title = "VIEW", businessType = BusinessType.DELETE)
	@DeleteMapping("/{taskIds}")
    public AjaxResult remove(@PathVariable Long[] taskIds)
    {
        return toAjax(vTaskService.deleteVTaskByIds(taskIds));
    }

    /**
     * 自定义sqlVIEW查询
     */
    @GetMapping("/customVTaskSql")
    public AjaxResult customVTaskSql(VTask vTask) {
        return AjaxResult.success(vTaskMapper.customVTaskSql(vTask));
    }
}
