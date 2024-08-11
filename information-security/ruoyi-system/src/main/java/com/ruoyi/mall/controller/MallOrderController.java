package com.ruoyi.mall.controller;

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
import com.ruoyi.mall.mapper.MallOrderMapper;
import com.ruoyi.mall.domain.MallOrder;
import com.ruoyi.mall.service.IMallOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单Controller
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
@RestController
@RequestMapping("/mall/order")
public class MallOrderController extends BaseController
{
    private static final Logger logger = LoggerFactory.getLogger(MallOrderController.class);

    @Autowired
    private IMallOrderService mallOrderService;

    @Autowired
    private MallOrderMapper mallOrderMapper;

    /**
     * 查询订单列表
     */
    @PreAuthorize("@ss.hasPermi('mall:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(MallOrder mallOrder)
    {
        startPage();
        List<MallOrder> list = mallOrderService.selectMallOrderList(mallOrder);
        return getDataTable(list);
    }

    /**
     * 导出订单列表
     */
    @PreAuthorize("@ss.hasPermi('mall:order:export')")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MallOrder mallOrder)
    {
        List<MallOrder> list = mallOrderService.selectMallOrderList(mallOrder);
        ExcelUtil<MallOrder> util = new ExcelUtil<MallOrder>(MallOrder.class);
        return util.exportExcel(list, "order");
    }

    /**
     * 获取订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('mall:order:query')")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") Long orderId)
    {
        return AjaxResult.success(mallOrderService.selectMallOrderById(orderId));
    }

    /**
     * 新增订单
     */
    @PreAuthorize("@ss.hasPermi('mall:order:add')")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MallOrder mallOrder)
    {
        return toAjax(mallOrderService.insertMallOrder(mallOrder));
    }

    /**
     * 修改订单
     */
    @PreAuthorize("@ss.hasPermi('mall:order:edit')")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MallOrder mallOrder)
    {
        return toAjax(mallOrderService.updateMallOrder(mallOrder));
    }

    /**
     * 删除订单
     */
    @PreAuthorize("@ss.hasPermi('mall:order:remove')")
    @Log(title = "订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable Long[] orderIds)
    {
        return toAjax(mallOrderService.deleteMallOrderByIds(orderIds));
    }

    /**
     * 自定义sql订单查询
     */
    @GetMapping("/customMallOrderSql")
    public AjaxResult customMallOrderSql(MallOrder mallOrder) {
        return AjaxResult.success(mallOrderMapper.customMallOrderSql(mallOrder));
    }
}
