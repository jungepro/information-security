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
import com.ruoyi.mall.mapper.MallFavoriteMapper;
import com.ruoyi.mall.domain.MallFavorite;
import com.ruoyi.mall.service.IMallFavoriteService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 收藏Controller
 * 
 * @author ruoyi
 * @date 2022-02-09
 */
@RestController
@RequestMapping("/mall/favorite")
public class MallFavoriteController extends BaseController
{
    private static final Logger logger = LoggerFactory.getLogger(MallFavoriteController.class);

    @Autowired
    private IMallFavoriteService mallFavoriteService;

    @Autowired
    private MallFavoriteMapper mallFavoriteMapper;

    /**
     * 查询收藏列表
     */
    @PreAuthorize("@ss.hasPermi('mall:favorite:list')")
    @GetMapping("/list")
    public TableDataInfo list(MallFavorite mallFavorite)
    {
        startPage();
        List<MallFavorite> list = mallFavoriteService.selectMallFavoriteList(mallFavorite);
        return getDataTable(list);
    }

    /**
     * 导出收藏列表
     */
    @PreAuthorize("@ss.hasPermi('mall:favorite:export')")
    @Log(title = "收藏", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MallFavorite mallFavorite)
    {
        List<MallFavorite> list = mallFavoriteService.selectMallFavoriteList(mallFavorite);
        ExcelUtil<MallFavorite> util = new ExcelUtil<MallFavorite>(MallFavorite.class);
        return util.exportExcel(list, "favorite");
    }

    /**
     * 获取收藏详细信息
     */
    @PreAuthorize("@ss.hasPermi('mall:favorite:query')")
    @GetMapping(value = "/{favoriteId}")
    public AjaxResult getInfo(@PathVariable("favoriteId") Long favoriteId)
    {
        return AjaxResult.success(mallFavoriteService.selectMallFavoriteById(favoriteId));
    }

    /**
     * 新增收藏
     */
    @PreAuthorize("@ss.hasPermi('mall:favorite:add')")
    @Log(title = "收藏", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MallFavorite mallFavorite)
    {
        return toAjax(mallFavoriteService.insertMallFavorite(mallFavorite));
    }

    /**
     * 修改收藏
     */
    @PreAuthorize("@ss.hasPermi('mall:favorite:edit')")
    @Log(title = "收藏", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MallFavorite mallFavorite)
    {
        return toAjax(mallFavoriteService.updateMallFavorite(mallFavorite));
    }

    /**
     * 删除收藏
     */
    @PreAuthorize("@ss.hasPermi('mall:favorite:remove')")
    @Log(title = "收藏", businessType = BusinessType.DELETE)
	@DeleteMapping("/{favoriteIds}")
    public AjaxResult remove(@PathVariable Long[] favoriteIds)
    {
        return toAjax(mallFavoriteService.deleteMallFavoriteByIds(favoriteIds));
    }

    /**
     * 自定义sql收藏查询
     */
    @GetMapping("/customMallFavoriteSql")
    public AjaxResult customMallFavoriteSql(MallFavorite mallFavorite) {
        return AjaxResult.success(mallFavoriteMapper.customMallFavoriteSql(mallFavorite));
    }
}
