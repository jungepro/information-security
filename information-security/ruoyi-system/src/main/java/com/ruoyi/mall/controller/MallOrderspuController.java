package com.ruoyi.mall.controller;

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
import com.ruoyi.mall.mapper.MallOrderspuMapper;
import com.ruoyi.mall.domain.MallOrderspu;
import com.ruoyi.mall.service.IMallOrderspuService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单商品对照Controller
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
@RestController
@RequestMapping("/mall/orderspu")
public class MallOrderspuController extends BaseController
{
    private static final Logger logger = LoggerFactory.getLogger(MallOrderspuController.class);

    @Autowired
    private IMallOrderspuService mallOrderspuService;

    @Autowired
    private MallOrderspuMapper mallOrderspuMapper;

    /**
     * 查询订单商品对照列表
     */
    @PreAuthorize("@ss.hasPermi('mall:orderspu:list')")
    @GetMapping("/list")
    public TableDataInfo list(MallOrderspu mallOrderspu)
    {
        startPage();
        List<MallOrderspu> list = mallOrderspuService.selectMallOrderspuList(mallOrderspu);
        return getDataTable(list);
    }

    /**
     * 导出订单商品对照列表
     */
    @PreAuthorize("@ss.hasPermi('mall:orderspu:export')")
    @Log(title = "订单商品对照", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MallOrderspu mallOrderspu)
    {
        List<MallOrderspu> list = mallOrderspuService.selectMallOrderspuList(mallOrderspu);
        ExcelUtil<MallOrderspu> util = new ExcelUtil<MallOrderspu>(MallOrderspu.class);
        return util.exportExcel(list, "orderspu");
    }

    /**
     * 获取订单商品对照详细信息
     */
    @PreAuthorize("@ss.hasPermi('mall:orderspu:query')")
    @GetMapping(value = "/{orderspuId}")
    public AjaxResult getInfo(@PathVariable("orderspuId") Long orderspuId)
    {
        return AjaxResult.success(mallOrderspuService.selectMallOrderspuById(orderspuId));
    }

    /**
     * 新增订单商品对照
     */
    @PreAuthorize("@ss.hasPermi('mall:orderspu:add')")
    @Log(title = "订单商品对照", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MallOrderspu mallOrderspu)
    {
        return toAjax(mallOrderspuService.insertMallOrderspu(mallOrderspu));
    }

    /**
     * 修改订单商品对照
     */
    @PreAuthorize("@ss.hasPermi('mall:orderspu:edit')")
    @Log(title = "订单商品对照", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MallOrderspu mallOrderspu)
    {
        return toAjax(mallOrderspuService.updateMallOrderspu(mallOrderspu));
    }

    /**
     * 删除订单商品对照
     */
    @PreAuthorize("@ss.hasPermi('mall:orderspu:remove')")
    @Log(title = "订单商品对照", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderspuIds}")
    public AjaxResult remove(@PathVariable Long[] orderspuIds)
    {
        return toAjax(mallOrderspuService.deleteMallOrderspuByIds(orderspuIds));
    }

    /**
     * 自定义sql订单商品对照查询
     */
    @GetMapping("/customMallOrderspuSql")
    public AjaxResult customMallOrderspuSql(MallOrderspu mallOrderspu) {
        return AjaxResult.success(mallOrderspuMapper.customMallOrderspuSql(mallOrderspu));
    }
}
