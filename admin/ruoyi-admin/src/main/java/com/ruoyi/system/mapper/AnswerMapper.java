package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Answer;

/**
 * 回答管理Mapper接口
 * 
 * @author felix
 * @date 2023-04-16
 */
public interface AnswerMapper 
{
    /**
     * 查询回答管理
     * 
     * @param id 回答管理主键
     * @return 回答管理
     */
    public Answer selectAnswerById(Long id);

    /**
     * 查询回答管理列表
     * 
     * @param answer 回答管理
     * @return 回答管理集合
     */
    public List<Answer> selectAnswerList(Answer answer);

    /**
     * 新增回答管理
     * 
     * @param answer 回答管理
     * @return 结果
     */
    public int insertAnswer(Answer answer);

    /**
     * 修改回答管理
     * 
     * @param answer 回答管理
     * @return 结果
     */
    public int updateAnswer(Answer answer);

    /**
     * 删除回答管理
     * 
     * @param id 回答管理主键
     * @return 结果
     */
    public int deleteAnswerById(Long id);

    /**
     * 批量删除回答管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAnswerByIds(Long[] ids);
}
