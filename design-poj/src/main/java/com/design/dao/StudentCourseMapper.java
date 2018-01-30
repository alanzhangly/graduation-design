package com.design.dao;

import com.design.pojo.StudentCourse;

public interface StudentCourseMapper {
    int deleteByPrimaryKey(String studentCourseId);

    int insert(StudentCourse record);

    int insertSelective(StudentCourse record);

    StudentCourse selectByPrimaryKey(String studentCourseId);

    int updateByPrimaryKeySelective(StudentCourse record);

    int updateByPrimaryKey(StudentCourse record);
}