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
import com.ruoyi.mall.mapper.MallCartMapper;
import com.ruoyi.mall.domain.MallCart;
import com.ruoyi.mall.service.IMallCartService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 购物车Controller
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
@RestController
@RequestMapping("/mall/cart")
public class MallCartController extends BaseController
{
    private static final Logger logger = LoggerFactory.getLogger(MallCartController.class);

    @Autowired
    private IMallCartService mallCartService;

    @Autowired
    private MallCartMapper mallCartMapper;

    /**
     * 查询购物车列表
     */
    @PreAuthorize("@ss.hasPermi('mall:cart:list')")
    @GetMapping("/list")
    public TableDataInfo list(MallCart mallCart)
    {
        startPage();
        List<MallCart> list = mallCartService.selectMallCartList(mallCart);
        return getDataTable(list);
    }

    /**
     * 导出购物车列表
     */
    @PreAuthorize("@ss.hasPermi('mall:cart:export')")
    @Log(title = "购物车", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MallCart mallCart)
    {
        List<MallCart> list = mallCartService.selectMallCartList(mallCart);
        ExcelUtil<MallCart> util = new ExcelUtil<MallCart>(MallCart.class);
        return util.exportExcel(list, "cart");
    }

    /**
     * 获取购物车详细信息
     */
    @PreAuthorize("@ss.hasPermi('mall:cart:query')")
    @GetMapping(value = "/{cartId}")
    public AjaxResult getInfo(@PathVariable("cartId") Long cartId)
    {
        return AjaxResult.success(mallCartService.selectMallCartById(cartId));
    }

    /**
     * 新增购物车
     */
    @PreAuthorize("@ss.hasPermi('mall:cart:add')")
    @Log(title = "购物车", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MallCart mallCart)
    {
        return toAjax(mallCartService.insertMallCart(mallCart));
    }

    /**
     * 修改购物车
     */
    @PreAuthorize("@ss.hasPermi('mall:cart:edit')")
    @Log(title = "购物车", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MallCart mallCart)
    {
        return toAjax(mallCartService.updateMallCart(mallCart));
    }

    /**
     * 删除购物车
     */
    @PreAuthorize("@ss.hasPermi('mall:cart:remove')")
    @Log(title = "购物车", businessType = BusinessType.DELETE)
	@DeleteMapping("/{cartIds}")
    public AjaxResult remove(@PathVariable Long[] cartIds)
    {
        return toAjax(mallCartService.deleteMallCartByIds(cartIds));
    }

    /**
     * 自定义sql购物车查询
     */
    @GetMapping("/customMallCartSql")
    public AjaxResult customMallCartSql(MallCart mallCart) {
        return AjaxResult.success(mallCartMapper.customMallCartSql(mallCart));
    }
}
