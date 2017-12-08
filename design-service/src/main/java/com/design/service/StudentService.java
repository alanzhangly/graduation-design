package com.design.service;

import com.design.service.model.StudentModel;

import java.util.Map;

/**
 * Created by Ke Zhang on 2017/12/8.
 */
public interface StudentService {

    /**
     * Excel 批量导入学生信息
     */
    void importStudentInfo();

    /**
     * 添加一条学生信息
     * 超级管理员权限
     * @param model
     */
    void addOne(StudentModel model);

    /**
     * 删除一条学生信息
     * @param studentId 主键号
     */
    void deleteOne(String studentId);

    /**
     * 删除一条记录
     * @param number  学生号
     */
    void deleteByNumber(String number);

    /**
     * 批量冻结学生帐号
     * @param studentIds 主键id
     */
    void freeze(String... studentIds);

    /**
     * 批量冻结
     * @param numbers  学生号
     */
    void freezeByNumber(String... numbers);

    /**
     * 更新一条学生信息
     * @param model
     * @return
     */
    StudentModel update(StudentModel model);

    /**
     * 按条件分页查询
     * @param model
     * @return
     */
    Map selectByModel(StudentModel model);

    /**
     * 根据学生号查询
     * @param studentNumber  学生号
     * @return
     */
    StudentModel selectByNumber(String studentNumber);

    /**
     * 根据主键查询
     * @param studentId  主键
     * @return
     */
    StudentModel selectById(String studentId);
}
