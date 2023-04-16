package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Teacher;

/**
 * 教师管理Service接口
 * 
 * @author felix
 * @date 2023-04-16
 */
public interface ITeacherService 
{
    /**
     * 查询教师管理
     * 
     * @param id 教师管理主键
     * @return 教师管理
     */
    public Teacher selectTeacherById(Long id);

    /**
     * 查询教师管理列表
     * 
     * @param teacher 教师管理
     * @return 教师管理集合
     */
    public List<Teacher> selectTeacherList(Teacher teacher);

    /**
     * 新增教师管理
     * 
     * @param teacher 教师管理
     * @return 结果
     */
    public int insertTeacher(Teacher teacher);

    /**
     * 修改教师管理
     * 
     * @param teacher 教师管理
     * @return 结果
     */
    public int updateTeacher(Teacher teacher);

    /**
     * 批量删除教师管理
     * 
     * @param ids 需要删除的教师管理主键集合
     * @return 结果
     */
    public int deleteTeacherByIds(Long[] ids);

    /**
     * 删除教师管理信息
     * 
     * @param id 教师管理主键
     * @return 结果
     */
    public int deleteTeacherById(Long id);
}
