package com.ruoyi.custom.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.custom.mapper.TNoticeMapper;
import com.ruoyi.custom.domain.TNotice;
import com.ruoyi.custom.service.ITNoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 系统公告Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
@Service
public class TNoticeServiceImpl implements ITNoticeService 
{
    private static final Logger logger = LoggerFactory.getLogger(TNoticeServiceImpl.class);

    @Autowired
    private TNoticeMapper tNoticeMapper;

    /**
     * 查询系统公告
     * 
     * @param noticeId 系统公告ID
     * @return 系统公告
     */
    @Override
    public TNotice selectTNoticeById(Long noticeId)
    {
        return tNoticeMapper.selectTNoticeById(noticeId);
    }

    /**
     * 查询系统公告列表
     * 
     * @param tNotice 系统公告
     * @return 系统公告
     */
    @Override
    public List<TNotice> selectTNoticeList(TNotice tNotice)
    {
        return tNoticeMapper.selectTNoticeList(tNotice);
    }

    /**
     * 新增系统公告
     * 
     * @param tNotice 系统公告
     * @return 结果
     */
    @Override
    public int insertTNotice(TNotice tNotice)
    {
        tNotice.setCreateTime(DateUtils.getNowDate());
        return tNoticeMapper.insertTNotice(tNotice);
    }

    /**
     * 修改系统公告
     * 
     * @param tNotice 系统公告
     * @return 结果
     */
    @Override
    public int updateTNotice(TNotice tNotice)
    {
        tNotice.setUpdateTime(DateUtils.getNowDate());
        return tNoticeMapper.updateTNotice(tNotice);
    }

    /**
     * 批量删除系统公告
     * 
     * @param noticeIds 需要删除的系统公告ID
     * @return 结果
     */
    @Override
    public int deleteTNoticeByIds(Long[] noticeIds)
    {
        return tNoticeMapper.deleteTNoticeByIds(noticeIds);
    }

    /**
     * 删除系统公告信息
     * 
     * @param noticeId 系统公告ID
     * @return 结果
     */
    @Override
    public int deleteTNoticeById(Long noticeId)
    {
        return tNoticeMapper.deleteTNoticeById(noticeId);
    }
}
