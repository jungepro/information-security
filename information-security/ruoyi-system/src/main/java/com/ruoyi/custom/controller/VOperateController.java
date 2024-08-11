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
import com.ruoyi.custom.mapper.VOperateMapper;
import com.ruoyi.custom.domain.VOperate;
import com.ruoyi.custom.service.IVOperateService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * VIEWController
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
@RestController
@RequestMapping("/v_custom/operate")
public class VOperateController extends BaseController
{
    private static final Logger logger = LoggerFactory.getLogger(VOperateController.class);

    @Autowired
    private IVOperateService vOperateService;

    @Autowired
    private VOperateMapper vOperateMapper;

    /**
     * 查询VIEW列表
     */
    @PreAuthorize("@ss.hasPermi('custom:operate:list')")
    @GetMapping("/list")
    public TableDataInfo list(VOperate vOperate)
    {
        startPage();
        List<VOperate> list = vOperateService.selectVOperateList(vOperate);
        return getDataTable(list);
    }

    /**
     * 导出VIEW列表
     */
    @PreAuthorize("@ss.hasPermi('custom:operate:export')")
    @Log(title = "VIEW", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(VOperate vOperate)
    {
        List<VOperate> list = vOperateService.selectVOperateList(vOperate);
        ExcelUtil<VOperate> util = new ExcelUtil<VOperate>(VOperate.class);
        return util.exportExcel(list, "operate");
    }

    /**
     * 获取VIEW详细信息
     */
    @PreAuthorize("@ss.hasPermi('custom:operate:query')")
    @GetMapping(value = "/{operateId}")
    public AjaxResult getInfo(@PathVariable("operateId") Long operateId)
    {
        return AjaxResult.success(vOperateService.selectVOperateById(operateId));
    }

    /**
     * 新增VIEW
     */
    @PreAuthorize("@ss.hasPermi('custom:operate:add')")
    @Log(title = "VIEW", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VOperate vOperate)
    {
        return toAjax(vOperateService.insertVOperate(vOperate));
    }

    /**
     * 修改VIEW
     */
    @PreAuthorize("@ss.hasPermi('custom:operate:edit')")
    @Log(title = "VIEW", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VOperate vOperate)
    {
        return toAjax(vOperateService.updateVOperate(vOperate));
    }

    /**
     * 删除VIEW
     */
    @PreAuthorize("@ss.hasPermi('custom:operate:remove')")
    @Log(title = "VIEW", businessType = BusinessType.DELETE)
	@DeleteMapping("/{operateIds}")
    public AjaxResult remove(@PathVariable Long[] operateIds)
    {
        return toAjax(vOperateService.deleteVOperateByIds(operateIds));
    }

    /**
     * 自定义sqlVIEW查询
     */
    @GetMapping("/customVOperateSql")
    public AjaxResult customVOperateSql(VOperate vOperate) {
        return AjaxResult.success(vOperateMapper.customVOperateSql(vOperate));
    }
}
