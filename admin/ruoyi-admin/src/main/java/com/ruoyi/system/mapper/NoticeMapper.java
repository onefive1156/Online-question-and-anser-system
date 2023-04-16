package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Notice;

/**
 * 通知管理Mapper接口
 * 
 * @author felix
 * @date 2023-04-16
 */
public interface NoticeMapper 
{
    /**
     * 查询通知管理
     * 
     * @param id 通知管理主键
     * @return 通知管理
     */
    public Notice selectNoticeById(Long id);

    /**
     * 查询通知管理列表
     * 
     * @param notice 通知管理
     * @return 通知管理集合
     */
    public List<Notice> selectNoticeList(Notice notice);

    /**
     * 新增通知管理
     * 
     * @param notice 通知管理
     * @return 结果
     */
    public int insertNotice(Notice notice);

    /**
     * 修改通知管理
     * 
     * @param notice 通知管理
     * @return 结果
     */
    public int updateNotice(Notice notice);

    /**
     * 删除通知管理
     * 
     * @param id 通知管理主键
     * @return 结果
     */
    public int deleteNoticeById(Long id);

    /**
     * 批量删除通知管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNoticeByIds(Long[] ids);
}
