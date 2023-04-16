package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Classify;

/**
 * 分类管理Mapper接口
 * 
 * @author felix
 * @date 2023-04-16
 */
public interface ClassifyMapper 
{
    /**
     * 查询分类管理
     * 
     * @param id 分类管理主键
     * @return 分类管理
     */
    public Classify selectClassifyById(Long id);

    /**
     * 查询分类管理列表
     * 
     * @param classify 分类管理
     * @return 分类管理集合
     */
    public List<Classify> selectClassifyList(Classify classify);

    /**
     * 新增分类管理
     * 
     * @param classify 分类管理
     * @return 结果
     */
    public int insertClassify(Classify classify);

    /**
     * 修改分类管理
     * 
     * @param classify 分类管理
     * @return 结果
     */
    public int updateClassify(Classify classify);

    /**
     * 删除分类管理
     * 
     * @param id 分类管理主键
     * @return 结果
     */
    public int deleteClassifyById(Long id);

    /**
     * 批量删除分类管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClassifyByIds(Long[] ids);
}
