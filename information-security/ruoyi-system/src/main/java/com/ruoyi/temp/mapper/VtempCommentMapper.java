package com.ruoyi.temp.mapper;

import java.util.List;
import com.ruoyi.temp.domain.VtempComment;

/**
 * VIEWMapper接口
 * 
 * @author ruoyi
 * @date 2021-11-18
 */
public interface VtempCommentMapper 
{
    /**
     * 查询VIEW
     * 
     * @param commentId VIEWID
     * @return VIEW
     */
    public VtempComment selectVtempCommentById(Long commentId);

    /**
     * 查询VIEW列表
     * 
     * @param vtempComment VIEW
     * @return VIEW集合
     */
    public List<VtempComment> selectVtempCommentList(VtempComment vtempComment);

    /**
     * 新增VIEW
     * 
     * @param vtempComment VIEW
     * @return 结果
     */
    public int insertVtempComment(VtempComment vtempComment);

    /**
     * 修改VIEW
     * 
     * @param vtempComment VIEW
     * @return 结果
     */
    public int updateVtempComment(VtempComment vtempComment);

    /**
     * 删除VIEW
     * 
     * @param commentId VIEWID
     * @return 结果
     */
    public int deleteVtempCommentById(Long commentId);

    /**
     * 批量删除VIEW
     * 
     * @param commentIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteVtempCommentByIds(Long[] commentIds);
}
