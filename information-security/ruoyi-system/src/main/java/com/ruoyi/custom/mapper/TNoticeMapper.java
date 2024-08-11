package com.ruoyi.custom.mapper;

import java.util.List;
import com.ruoyi.custom.domain.TNotice;

/**
 * 系统公告Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-19
 */
public interface TNoticeMapper 
{
    /**
     * 查询系统公告
     * 
     * @param noticeId 系统公告ID
     * @return 系统公告
     */
    public TNotice selectTNoticeById(Long noticeId);

    /**
     * 查询系统公告列表
     * 
     * @param tNotice 系统公告
     * @return 系统公告集合
     */
    public List<TNotice> selectTNoticeList(TNotice tNotice);

    /**
     * 新增系统公告
     * 
     * @param tNotice 系统公告
     * @return 结果
     */
    public int insertTNotice(TNotice tNotice);

    /**
     * 修改系统公告
     * 
     * @param tNotice 系统公告
     * @return 结果
     */
    public int updateTNotice(TNotice tNotice);

    /**
     * 删除系统公告
     * 
     * @param noticeId 系统公告ID
     * @return 结果
     */
    public int deleteTNoticeById(Long noticeId);

    /**
     * 批量删除系统公告
     * 
     * @param noticeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTNoticeByIds(Long[] noticeIds);

    /**
     * 自定义sql系统公告查询
     */
    public List customTNoticeSql(TNotice tNotice);
}
