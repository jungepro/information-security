package com.ruoyi.temp.service;

import java.util.List;
import com.ruoyi.temp.domain.TempComment;

/**
 * 评论Service接口
 * 
 * @author ruoyi
 * @date 2021-11-18
 */
public interface ITempCommentService 
{
    /**
     * 查询评论
     * 
     * @param commentId 评论ID
     * @return 评论
     */
    public TempComment selectTempCommentById(Long commentId);

    /**
     * 查询评论列表
     * 
     * @param tempComment 评论
     * @return 评论集合
     */
    public List<TempComment> selectTempCommentList(TempComment tempComment);

    /**
     * 新增评论
     * 
     * @param tempComment 评论
     * @return 结果
     */
    public int insertTempComment(TempComment tempComment);

    /**
     * 修改评论
     * 
     * @param tempComment 评论
     * @return 结果
     */
    public int updateTempComment(TempComment tempComment);

    /**
     * 批量删除评论
     * 
     * @param commentIds 需要删除的评论ID
     * @return 结果
     */
    public int deleteTempCommentByIds(Long[] commentIds);

    /**
     * 删除评论信息
     * 
     * @param commentId 评论ID
     * @return 结果
     */
    public int deleteTempCommentById(Long commentId);
}
