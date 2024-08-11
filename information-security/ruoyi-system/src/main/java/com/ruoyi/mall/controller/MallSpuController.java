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
import com.ruoyi.mall.mapper.MallSpuMapper;
import com.ruoyi.mall.domain.MallSpu;
import com.ruoyi.mall.service.IMallSpuService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 商品Controller
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
@RestController
@RequestMapping("/mall/spu")
public class MallSpuController extends BaseController
{
    private static final Logger logger = LoggerFactory.getLogger(MallSpuController.class);

    @Autowired
    private IMallSpuService mallSpuService;

    @Autowired
    private MallSpuMapper mallSpuMapper;

    /**
     * 查询商品列表
     */
    @PreAuthorize("@ss.hasPermi('mall:spu:list')")
    @GetMapping("/list")
    public TableDataInfo list(MallSpu mallSpu)
    {
        startPage();
        List<MallSpu> list = mallSpuService.selectMallSpuList(mallSpu);
        return getDataTable(list);
    }

    /**
     * 导出商品列表
     */
    @PreAuthorize("@ss.hasPermi('mall:spu:export')")
    @Log(title = "商品", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MallSpu mallSpu)
    {
        List<MallSpu> list = mallSpuService.selectMallSpuList(mallSpu);
        ExcelUtil<MallSpu> util = new ExcelUtil<MallSpu>(MallSpu.class);
        return util.exportExcel(list, "spu");
    }

    /**
     * 获取商品详细信息
     */
    @PreAuthorize("@ss.hasPermi('mall:spu:query')")
    @GetMapping(value = "/{spuId}")
    public AjaxResult getInfo(@PathVariable("spuId") Long spuId)
    {
        return AjaxResult.success(mallSpuService.selectMallSpuById(spuId));
    }

    /**
     * 新增商品
     */
    @PreAuthorize("@ss.hasPermi('mall:spu:add')")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MallSpu mallSpu)
    {
        return toAjax(mallSpuService.insertMallSpu(mallSpu));
    }

    /**
     * 修改商品
     */
    @PreAuthorize("@ss.hasPermi('mall:spu:edit')")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MallSpu mallSpu)
    {
        return toAjax(mallSpuService.updateMallSpu(mallSpu));
    }

    /**
     * 删除商品
     */
    @PreAuthorize("@ss.hasPermi('mall:spu:remove')")
    @Log(title = "商品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{spuIds}")
    public AjaxResult remove(@PathVariable Long[] spuIds)
    {
        return toAjax(mallSpuService.deleteMallSpuByIds(spuIds));
    }

    /**
     * 自定义sql商品查询
     */
    @GetMapping("/customMallSpuSql")
    public AjaxResult customMallSpuSql(MallSpu mallSpu) {
        return AjaxResult.success(mallSpuMapper.customMallSpuSql(mallSpu));
    }
}
