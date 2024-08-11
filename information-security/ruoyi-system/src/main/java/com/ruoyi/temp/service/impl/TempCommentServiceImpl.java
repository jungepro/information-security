package com.ruoyi.temp.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.temp.mapper.TempCommentMapper;
import com.ruoyi.temp.domain.TempComment;
import com.ruoyi.temp.service.ITempCommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 评论Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-11-18
 */
@Service
public class TempCommentServiceImpl implements ITempCommentService 
{
    private static final Logger logger = LoggerFactory.getLogger(TempCommentServiceImpl.class);

    @Autowired
    private TempCommentMapper tempCommentMapper;

    /**
     * 查询评论
     * 
     * @param commentId 评论ID
     * @return 评论
     */
    @Override
    public TempComment selectTempCommentById(Long commentId)
    {
        return tempCommentMapper.selectTempCommentById(commentId);
    }

    /**
     * 查询评论列表
     * 
     * @param tempComment 评论
     * @return 评论
     */
    @Override
    public List<TempComment> selectTempCommentList(TempComment tempComment)
    {
        return tempCommentMapper.selectTempCommentList(tempComment);
    }

    /**
     * 新增评论
     * 
     * @param tempComment 评论
     * @return 结果
     */
    @Override
    public int insertTempComment(TempComment tempComment)
    {
        tempComment.setCreateTime(DateUtils.getNowDate());
        return tempCommentMapper.insertTempComment(tempComment);
    }

    /**
     * 修改评论
     * 
     * @param tempComment 评论
     * @return 结果
     */
    @Override
    public int updateTempComment(TempComment tempComment)
    {
        return tempCommentMapper.updateTempComment(tempComment);
    }

    /**
     * 批量删除评论
     * 
     * @param commentIds 需要删除的评论ID
     * @return 结果
     */
    @Override
    public int deleteTempCommentByIds(Long[] commentIds)
    {
        return tempCommentMapper.deleteTempCommentByIds(commentIds);
    }

    /**
     * 删除评论信息
     * 
     * @param commentId 评论ID
     * @return 结果
     */
    @Override
    public int deleteTempCommentById(Long commentId)
    {
        return tempCommentMapper.deleteTempCommentById(commentId);
    }
}
