package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.system.domain.Answer;
import com.ruoyi.system.mapper.ProblemMapper;
import com.ruoyi.system.domain.Problem;
import com.ruoyi.system.service.IProblemService;

/**
 * 问题管理Service业务层处理
 * 
 * @author felix
 * @date 2023-04-16
 */
@Service
public class ProblemServiceImpl implements IProblemService 
{
    @Autowired
    private ProblemMapper problemMapper;

    /**
     * 查询问题管理
     * 
     * @param id 问题管理主键
     * @return 问题管理
     */
    @Override
    public Problem selectProblemById(Long id)
    {
        return problemMapper.selectProblemById(id);
    }

    /**
     * 查询问题管理列表
     * 
     * @param problem 问题管理
     * @return 问题管理
     */
    @Override
    public List<Problem> selectProblemList(Problem problem)
    {
        return problemMapper.selectProblemList(problem);
    }

    /**
     * 新增问题管理
     * 
     * @param problem 问题管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertProblem(Problem problem)
    {
        problem.setCreateTime(DateUtils.getNowDate());
        int rows = problemMapper.insertProblem(problem);
        insertAnswer(problem);
        return rows;
    }

    /**
     * 修改问题管理
     * 
     * @param problem 问题管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateProblem(Problem problem)
    {
        problemMapper.deleteAnswerByBelongsTo(problem.getId());
        insertAnswer(problem);
        return problemMapper.updateProblem(problem);
    }

    /**
     * 批量删除问题管理
     * 
     * @param ids 需要删除的问题管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteProblemByIds(Long[] ids)
    {
        problemMapper.deleteAnswerByBelongsTos(ids);
        return problemMapper.deleteProblemByIds(ids);
    }

    /**
     * 删除问题管理信息
     * 
     * @param id 问题管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteProblemById(Long id)
    {
        problemMapper.deleteAnswerByBelongsTo(id);
        return problemMapper.deleteProblemById(id);
    }

    /**
     * 新增回答管理信息
     * 
     * @param problem 问题管理对象
     */
    public void insertAnswer(Problem problem)
    {
        List<Answer> answerList = problem.getAnswerList();
        Long id = problem.getId();
        if (StringUtils.isNotNull(answerList))
        {
            List<Answer> list = new ArrayList<Answer>();
            for (Answer answer : answerList)
            {
                answer.setBelongsTo(id);
                list.add(answer);
            }
            if (list.size() > 0)
            {
                problemMapper.batchAnswer(list);
            }
        }
    }
}
