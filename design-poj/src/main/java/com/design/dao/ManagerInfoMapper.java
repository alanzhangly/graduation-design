package com.design.dao;

import com.design.pojo.ManagerInfo;

public interface ManagerInfoMapper {
    int deleteByPrimaryKey(String managerId);

    int insert(ManagerInfo record);

    int insertSelective(ManagerInfo record);

    ManagerInfo selectByPrimaryKey(String managerId);

    int updateByPrimaryKeySelective(ManagerInfo record);

    int updateByPrimaryKey(ManagerInfo record);
}