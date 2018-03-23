package com.design.dao;

import com.design.pojo.CourseInfo;

import java.util.List;

public interface CourseInfoMapper {
    int deleteByPrimaryKey(String courseId);

    int insert(CourseInfo record);

    int insertSelective(CourseInfo record);

    int addBatch(List<CourseInfo> list);

    CourseInfo selectByPrimaryKey(String courseId);

    int updateByPrimaryKeySelective(CourseInfo record);

    int updateByPrimaryKey(CourseInfo record);
}