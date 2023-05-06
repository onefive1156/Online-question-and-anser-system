package com.felix.mapper;

import com.felix.domain.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface StudentMapper
{
    /**
     * 查询学生管理
     *
     * @param id 学生管理主键
     * @return 学生管理
     */
    public Student selectStudentById(Long id);
    
    /**
     * 查询学生管理列表
     *
     * @param student 学生管理
     * @return 学生管理集合
     */
    public List<Student> selectStudentList(Student student);
    
    /**
     * 新增学生管理
     *
     * @param student 学生管理
     * @return 结果
     */
    public int insertStudent(Student student);
    
    /**
     * 修改学生管理
     *
     * @param student 学生管理
     * @return 结果
     */
    public int updateStudent(Student student);
    
    /**
     * 删除学生管理
     *
     * @param id 学生管理主键
     * @return 结果
     */
    public int deleteStudentById(Long id);
    
    /**
     * 批量删除学生管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentByIds(Long[] ids);
}
