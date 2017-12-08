package com.design.dao;

import com.design.pojo.TeacherInfo;

public interface TeacherInfoMapper {
    int deleteByPrimaryKey(String teacherId);

    int insert(TeacherInfo record);

    int insertSelective(TeacherInfo record);

    TeacherInfo selectByPrimaryKey(String teacherId);

    int updateByPrimaryKeySelective(TeacherInfo record);

    int updateByPrimaryKey(TeacherInfo record);
}