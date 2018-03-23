package com.design.dao;

import com.design.pojo.StudentInfo;

import java.util.List;

public interface StudentInfoMapper {
    int deleteByPrimaryKey(String userId);

    int insert(StudentInfo record);

    int addBatch(List<StudentInfo> list);

    int insertSelective(StudentInfo record);

    StudentInfo selectByPrimaryKey(String userId);

    List<String> selectIdsByModel(StudentInfo record);

    int updateByPrimaryKeySelective(StudentInfo record);

    int updateByPrimaryKey(StudentInfo record);
}