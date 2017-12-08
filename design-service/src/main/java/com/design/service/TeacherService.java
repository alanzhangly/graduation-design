package com.design.service;

import com.design.service.model.TeacherModel;

import java.util.Map;

/**
 * Created by Ke Zhang on 2017/12/8.
 */
public interface TeacherService {

    /**
     * Excel 批量导入教师信息
     */
    void importTeacherInfo();

    /**
     * 添加一条教师信息
     * @param model
     */
    void addOne(TeacherModel model);

    /**
     * 按id号批量冻结
     * @param teacherIds  主键号
     */
    void freeze(String... teacherIds);

    /**
     * 批量冻结
     * @param numbers  职工号
     */
    void freezeByNumber(String... numbers);

    /**
     * 更新信息
     * @param model
     * @return
     */
    TeacherModel update(TeacherModel model);

    /**
     * 条件查询
     * @param model
     * @return
     */
    Map selectByModel(TeacherModel model);

    /**
     * 按职工号查询
     * @param number
     * @return
     */
    TeacherModel selectByNumber(String number);
}
