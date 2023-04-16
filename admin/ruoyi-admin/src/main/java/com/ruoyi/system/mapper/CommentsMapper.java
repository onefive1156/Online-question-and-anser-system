package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Comments;

/**
 * 评论管理Mapper接口
 * 
 * @author felix
 * @date 2023-04-16
 */
public interface CommentsMapper 
{
    /**
     * 查询评论管理
     * 
     * @param id 评论管理主键
     * @return 评论管理
     */
    public Comments selectCommentsById(Long id);

    /**
     * 查询评论管理列表
     * 
     * @param comments 评论管理
     * @return 评论管理集合
     */
    public List<Comments> selectCommentsList(Comments comments);

    /**
     * 新增评论管理
     * 
     * @param comments 评论管理
     * @return 结果
     */
    public int insertComments(Comments comments);

    /**
     * 修改评论管理
     * 
     * @param comments 评论管理
     * @return 结果
     */
    public int updateComments(Comments comments);

    /**
     * 删除评论管理
     * 
     * @param id 评论管理主键
     * @return 结果
     */
    public int deleteCommentsById(Long id);

    /**
     * 批量删除评论管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCommentsByIds(Long[] ids);
}
