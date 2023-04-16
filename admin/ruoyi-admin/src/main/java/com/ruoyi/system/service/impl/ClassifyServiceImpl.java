package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ClassifyMapper;
import com.ruoyi.system.domain.Classify;
import com.ruoyi.system.service.IClassifyService;

/**
 * 分类管理Service业务层处理
 * 
 * @author felix
 * @date 2023-04-16
 */
@Service
public class ClassifyServiceImpl implements IClassifyService 
{
    @Autowired
    private ClassifyMapper classifyMapper;

    /**
     * 查询分类管理
     * 
     * @param id 分类管理主键
     * @return 分类管理
     */
    @Override
    public Classify selectClassifyById(Long id)
    {
        return classifyMapper.selectClassifyById(id);
    }

    /**
     * 查询分类管理列表
     * 
     * @param classify 分类管理
     * @return 分类管理
     */
    @Override
    public List<Classify> selectClassifyList(Classify classify)
    {
        return classifyMapper.selectClassifyList(classify);
    }

    /**
     * 新增分类管理
     * 
     * @param classify 分类管理
     * @return 结果
     */
    @Override
    public int insertClassify(Classify classify)
    {
        classify.setCreateTime(DateUtils.getNowDate());
        return classifyMapper.insertClassify(classify);
    }

    /**
     * 修改分类管理
     * 
     * @param classify 分类管理
     * @return 结果
     */
    @Override
    public int updateClassify(Classify classify)
    {
        return classifyMapper.updateClassify(classify);
    }

    /**
     * 批量删除分类管理
     * 
     * @param ids 需要删除的分类管理主键
     * @return 结果
     */
    @Override
    public int deleteClassifyByIds(Long[] ids)
    {
        return classifyMapper.deleteClassifyByIds(ids);
    }

    /**
     * 删除分类管理信息
     * 
     * @param id 分类管理主键
     * @return 结果
     */
    @Override
    public int deleteClassifyById(Long id)
    {
        return classifyMapper.deleteClassifyById(id);
    }
}
