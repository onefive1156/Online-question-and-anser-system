package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Problem;
import com.ruoyi.system.domain.Answer;

/**
 * 问题管理Mapper接口
 * 
 * @author felix
 * @date 2023-04-16
 */
public interface ProblemMapper 
{
    /**
     * 查询问题管理
     * 
     * @param id 问题管理主键
     * @return 问题管理
     */
    public Problem selectProblemById(Long id);

    /**
     * 查询问题管理列表
     * 
     * @param problem 问题管理
     * @return 问题管理集合
     */
    public List<Problem> selectProblemList(Problem problem);

    /**
     * 新增问题管理
     * 
     * @param problem 问题管理
     * @return 结果
     */
    public int insertProblem(Problem problem);

    /**
     * 修改问题管理
     * 
     * @param problem 问题管理
     * @return 结果
     */
    public int updateProblem(Problem problem);

    /**
     * 删除问题管理
     * 
     * @param id 问题管理主键
     * @return 结果
     */
    public int deleteProblemById(Long id);

    /**
     * 批量删除问题管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProblemByIds(Long[] ids);

    /**
     * 批量删除回答管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAnswerByBelongsTos(Long[] ids);
    
    /**
     * 批量新增回答管理
     * 
     * @param answerList 回答管理列表
     * @return 结果
     */
    public int batchAnswer(List<Answer> answerList);
    

    /**
     * 通过问题管理主键删除回答管理信息
     * 
     * @param id 问题管理ID
     * @return 结果
     */
    public int deleteAnswerByBelongsTo(Long id);
}
