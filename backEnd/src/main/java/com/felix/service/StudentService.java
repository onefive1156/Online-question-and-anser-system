package com.felix.service;

import com.felix.domain.Student;

import java.util.List;

public interface StudentService{
    public Student selectStudentById(Long id);
    public Student selectStudentByWXId(String weixinId);
    /**
     * 查询学生列表
     *
     * @param student 学生管理
     * @return 学生管理集合
     */
    public List<Student> selectStudentList(Student student);
    
    /**
     * 新增学生
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
     * 批量删除学生管理
     *
     * @param ids 需要删除的学生管理主键集合
     * @return 结果
     */
    public int deleteStudentByIds(Long[] ids);
}
