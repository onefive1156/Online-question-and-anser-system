package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AnswerMapper;
import com.ruoyi.system.domain.Answer;
import com.ruoyi.system.service.IAnswerService;

/**
 * 回答管理Service业务层处理
 * 
 * @author felix
 * @date 2023-04-16
 */
@Service
public class AnswerServiceImpl implements IAnswerService 
{
    @Autowired
    private AnswerMapper answerMapper;

    /**
     * 查询回答管理
     * 
     * @param id 回答管理主键
     * @return 回答管理
     */
    @Override
    public Answer selectAnswerById(Long id)
    {
        return answerMapper.selectAnswerById(id);
    }

    /**
     * 查询回答管理列表
     * 
     * @param answer 回答管理
     * @return 回答管理
     */
    @Override
    public List<Answer> selectAnswerList(Answer answer)
    {
        return answerMapper.selectAnswerList(answer);
    }

    /**
     * 新增回答管理
     * 
     * @param answer 回答管理
     * @return 结果
     */
    @Override
    public int insertAnswer(Answer answer)
    {
        answer.setCreateTime(DateUtils.getNowDate());
        return answerMapper.insertAnswer(answer);
    }

    /**
     * 修改回答管理
     * 
     * @param answer 回答管理
     * @return 结果
     */
    @Override
    public int updateAnswer(Answer answer)
    {
        return answerMapper.updateAnswer(answer);
    }

    /**
     * 批量删除回答管理
     * 
     * @param ids 需要删除的回答管理主键
     * @return 结果
     */
    @Override
    public int deleteAnswerByIds(Long[] ids)
    {
        return answerMapper.deleteAnswerByIds(ids);
    }

    /**
     * 删除回答管理信息
     * 
     * @param id 回答管理主键
     * @return 结果
     */
    @Override
    public int deleteAnswerById(Long id)
    {
        return answerMapper.deleteAnswerById(id);
    }
}
