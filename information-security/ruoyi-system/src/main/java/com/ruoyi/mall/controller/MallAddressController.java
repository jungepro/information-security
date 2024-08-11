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
import com.ruoyi.mall.mapper.MallAddressMapper;
import com.ruoyi.mall.domain.MallAddress;
import com.ruoyi.mall.service.IMallAddressService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 地址Controller
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
@RestController
@RequestMapping("/mall/address")
public class MallAddressController extends BaseController
{
    private static final Logger logger = LoggerFactory.getLogger(MallAddressController.class);

    @Autowired
    private IMallAddressService mallAddressService;

    @Autowired
    private MallAddressMapper mallAddressMapper;

    /**
     * 查询地址列表
     */
    @PreAuthorize("@ss.hasPermi('mall:address:list')")
    @GetMapping("/list")
    public TableDataInfo list(MallAddress mallAddress)
    {
        startPage();
        List<MallAddress> list = mallAddressService.selectMallAddressList(mallAddress);
        return getDataTable(list);
    }

    /**
     * 导出地址列表
     */
    @PreAuthorize("@ss.hasPermi('mall:address:export')")
    @Log(title = "地址", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MallAddress mallAddress)
    {
        List<MallAddress> list = mallAddressService.selectMallAddressList(mallAddress);
        ExcelUtil<MallAddress> util = new ExcelUtil<MallAddress>(MallAddress.class);
        return util.exportExcel(list, "address");
    }

    /**
     * 获取地址详细信息
     */
    @PreAuthorize("@ss.hasPermi('mall:address:query')")
    @GetMapping(value = "/{addressId}")
    public AjaxResult getInfo(@PathVariable("addressId") Long addressId)
    {
        return AjaxResult.success(mallAddressService.selectMallAddressById(addressId));
    }

    /**
     * 新增地址
     */
    @PreAuthorize("@ss.hasPermi('mall:address:add')")
    @Log(title = "地址", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MallAddress mallAddress)
    {
        return toAjax(mallAddressService.insertMallAddress(mallAddress));
    }

    /**
     * 修改地址
     */
    @PreAuthorize("@ss.hasPermi('mall:address:edit')")
    @Log(title = "地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MallAddress mallAddress)
    {
        return toAjax(mallAddressService.updateMallAddress(mallAddress));
    }

    /**
     * 删除地址
     */
    @PreAuthorize("@ss.hasPermi('mall:address:remove')")
    @Log(title = "地址", businessType = BusinessType.DELETE)
	@DeleteMapping("/{addressIds}")
    public AjaxResult remove(@PathVariable Long[] addressIds)
    {
        return toAjax(mallAddressService.deleteMallAddressByIds(addressIds));
    }

    /**
     * 自定义sql地址查询
     */
    @GetMapping("/customMallAddressSql")
    public AjaxResult customMallAddressSql(MallAddress mallAddress) {
        return AjaxResult.success(mallAddressMapper.customMallAddressSql(mallAddress));
    }
}
