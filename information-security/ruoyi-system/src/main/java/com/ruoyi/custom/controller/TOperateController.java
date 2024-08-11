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
import com.ruoyi.custom.mapper.TOperateMapper;
import com.ruoyi.custom.domain.TOperate;
import com.ruoyi.custom.service.ITOperateService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 操作日志Controller
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
@RestController
@RequestMapping("/custom/operate")
public class TOperateController extends BaseController
{
    private static final Logger logger = LoggerFactory.getLogger(TOperateController.class);

    @Autowired
    private ITOperateService tOperateService;

    @Autowired
    private TOperateMapper tOperateMapper;

    /**
     * 查询操作日志列表
     */
    @PreAuthorize("@ss.hasPermi('custom:operate:list')")
    @GetMapping("/list")
    public TableDataInfo list(TOperate tOperate)
    {
        startPage();
        List<TOperate> list = tOperateService.selectTOperateList(tOperate);
        return getDataTable(list);
    }

    /**
     * 导出操作日志列表
     */
    @PreAuthorize("@ss.hasPermi('custom:operate:export')")
    @Log(title = "操作日志", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TOperate tOperate)
    {
        List<TOperate> list = tOperateService.selectTOperateList(tOperate);
        ExcelUtil<TOperate> util = new ExcelUtil<TOperate>(TOperate.class);
        return util.exportExcel(list, "operate");
    }

    /**
     * 获取操作日志详细信息
     */
    @PreAuthorize("@ss.hasPermi('custom:operate:query')")
    @GetMapping(value = "/{operateId}")
    public AjaxResult getInfo(@PathVariable("operateId") Long operateId)
    {
        return AjaxResult.success(tOperateService.selectTOperateById(operateId));
    }

    /**
     * 新增操作日志
     */
    @PreAuthorize("@ss.hasPermi('custom:operate:add')")
    @Log(title = "操作日志", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TOperate tOperate)
    {
        tOperate.setUserId(SecurityUtils.getLoginUser().getUser().getUserId());
        return toAjax(tOperateService.insertTOperate(tOperate));
    }

    /**
     * 修改操作日志
     */
    @PreAuthorize("@ss.hasPermi('custom:operate:edit')")
    @Log(title = "操作日志", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TOperate tOperate)
    {
        return toAjax(tOperateService.updateTOperate(tOperate));
    }

    /**
     * 删除操作日志
     */
    @PreAuthorize("@ss.hasPermi('custom:operate:remove')")
    @Log(title = "操作日志", businessType = BusinessType.DELETE)
	@DeleteMapping("/{operateIds}")
    public AjaxResult remove(@PathVariable Long[] operateIds)
    {
        return toAjax(tOperateService.deleteTOperateByIds(operateIds));
    }

    /**
     * 自定义sql操作日志查询
     */
    @GetMapping("/customTOperateSql")
    public AjaxResult customTOperateSql(TOperate tOperate) {
        return AjaxResult.success(tOperateMapper.customTOperateSql(tOperate));
    }
}
