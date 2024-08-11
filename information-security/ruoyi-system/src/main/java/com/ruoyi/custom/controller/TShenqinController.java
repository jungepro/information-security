package com.ruoyi.custom.controller;

import java.util.List;

import com.ruoyi.common.core.domain.model.LoginUser;
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
import com.ruoyi.custom.mapper.TShenqinMapper;
import com.ruoyi.custom.domain.TShenqin;
import com.ruoyi.custom.service.ITShenqinService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 申请Controller
 *
 * @author ruoyi
 * @date 2023-06-11
 */
@RestController
@RequestMapping("/custom/shenqin")
public class TShenqinController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(TShenqinController.class);

    @Autowired
    private ITShenqinService tShenqinService;

    @Autowired
    private TShenqinMapper tShenqinMapper;

    /**
     * 查询申请列表
     */
    @PreAuthorize("@ss.hasPermi('custom:shenqin:list')")
    @GetMapping("/list")
    public TableDataInfo list(TShenqin tShenqin) {
        String username = SecurityUtils.getUsername();
        if (!username.equals("admin")) {
            tShenqin.setCreateBy(username);
        }
        startPage();
        List<TShenqin> list = tShenqinService.selectTShenqinList(tShenqin);
        return getDataTable(list);
    }

    /**
     * 导出申请列表
     */
    @PreAuthorize("@ss.hasPermi('custom:shenqin:export')")
    @Log(title = "申请", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TShenqin tShenqin) {
        List<TShenqin> list = tShenqinService.selectTShenqinList(tShenqin);
        ExcelUtil<TShenqin> util = new ExcelUtil<TShenqin>(TShenqin.class);
        return util.exportExcel(list, "shenqin");
    }

    /**
     * 获取申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('custom:shenqin:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(tShenqinService.selectTShenqinById(id));
    }

    /**
     * 新增申请
     */
    @PreAuthorize("@ss.hasPermi('custom:shenqin:add')")
    @Log(title = "申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TShenqin tShenqin) {
        String username = SecurityUtils.getUsername();
        tShenqin.setCreateBy(username);
        return toAjax(tShenqinService.insertTShenqin(tShenqin));
    }

    /**
     * 修改申请
     */
    @PreAuthorize("@ss.hasPermi('custom:shenqin:edit')")
    @Log(title = "申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TShenqin tShenqin) {
        return toAjax(tShenqinService.updateTShenqin(tShenqin));
    }

    /**
     * 删除申请
     */
    @PreAuthorize("@ss.hasPermi('custom:shenqin:remove')")
    @Log(title = "申请", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tShenqinService.deleteTShenqinByIds(ids));
    }

    /**
     * 自定义sql申请查询
     */
    @GetMapping("/customTShenqinSql")
    public AjaxResult customTShenqinSql(TShenqin tShenqin) {
        return AjaxResult.success(tShenqinMapper.customTShenqinSql(tShenqin));
    }
}
