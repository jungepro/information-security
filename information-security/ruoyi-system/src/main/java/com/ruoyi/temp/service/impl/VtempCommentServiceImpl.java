package com.ruoyi.temp.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.temp.mapper.VtempCommentMapper;
import com.ruoyi.temp.domain.VtempComment;
import com.ruoyi.temp.service.IVtempCommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * VIEWService业务层处理
 * 
 * @author ruoyi
 * @date 2021-11-18
 */
@Service
public class VtempCommentServiceImpl implements IVtempCommentService 
{
    private static final Logger logger = LoggerFactory.getLogger(VtempCommentServiceImpl.class);

    @Autowired
    private VtempCommentMapper vtempCommentMapper;

    /**
     * 查询VIEW
     * 
     * @param commentId VIEWID
     * @return VIEW
     */
    @Override
    public VtempComment selectVtempCommentById(Long commentId)
    {
        return vtempCommentMapper.selectVtempCommentById(commentId);
    }

    /**
     * 查询VIEW列表
     * 
     * @param vtempComment VIEW
     * @return VIEW
     */
    @Override
    public List<VtempComment> selectVtempCommentList(VtempComment vtempComment)
    {
        return vtempCommentMapper.selectVtempCommentList(vtempComment);
    }

    /**
     * 新增VIEW
     * 
     * @param vtempComment VIEW
     * @return 结果
     */
    @Override
    public int insertVtempComment(VtempComment vtempComment)
    {
        vtempComment.setCreateTime(DateUtils.getNowDate());
        return vtempCommentMapper.insertVtempComment(vtempComment);
    }

    /**
     * 修改VIEW
     * 
     * @param vtempComment VIEW
     * @return 结果
     */
    @Override
    public int updateVtempComment(VtempComment vtempComment)
    {
        return vtempCommentMapper.updateVtempComment(vtempComment);
    }

    /**
     * 批量删除VIEW
     * 
     * @param commentIds 需要删除的VIEWID
     * @return 结果
     */
    @Override
    public int deleteVtempCommentByIds(Long[] commentIds)
    {
        return vtempCommentMapper.deleteVtempCommentByIds(commentIds);
    }

    /**
     * 删除VIEW信息
     * 
     * @param commentId VIEWID
     * @return 结果
     */
    @Override
    public int deleteVtempCommentById(Long commentId)
    {
        return vtempCommentMapper.deleteVtempCommentById(commentId);
    }
}
