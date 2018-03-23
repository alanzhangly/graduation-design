package com.design.dao;

import com.design.model.StudentCourseModel;
import com.design.pojo.StudentCourse;

import java.util.List;

public interface StudentCourseMapper {
    int deleteByPrimaryKey(String studentCourseId);

    int insert(StudentCourse record);

    int insertSelective(StudentCourse record);

    int addBatch(List<StudentCourseModel> list);

    StudentCourse selectByPrimaryKey(String studentCourseId);

    int updateByPrimaryKeySelective(StudentCourse record);

    int updateByPrimaryKey(StudentCourse record);
}