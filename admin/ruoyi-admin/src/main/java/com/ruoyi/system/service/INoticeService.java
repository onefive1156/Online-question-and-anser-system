package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Notice;

/**
 * 通知管理Service接口
 * 
 * @author felix
 * @date 2023-04-16
 */
public interface INoticeService 
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
     * 批量删除通知管理
     * 
     * @param ids 需要删除的通知管理主键集合
     * @return 结果
     */
    public int deleteNoticeByIds(Long[] ids);

    /**
     * 删除通知管理信息
     * 
     * @param id 通知管理主键
     * @return 结果
     */
    public int deleteNoticeById(Long id);
}
