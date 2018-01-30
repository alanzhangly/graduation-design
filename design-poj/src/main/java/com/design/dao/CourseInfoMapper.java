package com.design.dao;

import com.design.pojo.CourseInfo;

public interface CourseInfoMapper {
    int deleteByPrimaryKey(String courseId);

    int insert(CourseInfo record);

    int insertSelective(CourseInfo record);

    CourseInfo selectByPrimaryKey(String courseId);

    int updateByPrimaryKeySelective(CourseInfo record);

    int updateByPrimaryKey(CourseInfo record);
}