package com.design.dao;

import com.design.pojo.StudentInfo;

public interface StudentInfoMapper {
    int deleteByPrimaryKey(String userId);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    StudentInfo selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(StudentInfo record);

    int updateByPrimaryKey(StudentInfo record);
}