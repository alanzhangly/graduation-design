package com.design.dao;

import com.design.pojo.CollegeMajorInfo;

import java.util.List;

public interface CollegeMajorInfoMapper {
    int deleteByPrimaryKey(String cmId);

    int insert(CollegeMajorInfo record);

    int addBatch(List<CollegeMajorInfo> list);

    int insertSelective(CollegeMajorInfo record);

    CollegeMajorInfo selectByPrimaryKey(String cmId);

    List<CollegeMajorInfo> selectAllColleges();

    List<CollegeMajorInfo> selectMajorsByCollegeEn(String collegeEn);

    String selectIdByName(String name);

    int updateByPrimaryKeySelective(CollegeMajorInfo record);

    int updateByPrimaryKey(CollegeMajorInfo record);
}