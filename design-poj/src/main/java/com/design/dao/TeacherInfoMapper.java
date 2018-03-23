package com.design.dao;

import com.design.pojo.TeacherInfo;

import java.util.List;

public interface TeacherInfoMapper {
    int deleteByPrimaryKey(String teacherId);

    int insert(TeacherInfo record);

    int insertSelective(TeacherInfo record);

    int addBatch(List<TeacherInfo> list);

    TeacherInfo selectByPrimaryKey(String teacherId);

    int updateByPrimaryKeySelective(TeacherInfo record);

    int updateByPrimaryKey(TeacherInfo record);
}