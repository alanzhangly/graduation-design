package com.design.service;

import com.design.service.model.CollegeMajorModel;

import java.util.List;

/**
 * Created by Ke Zhang on 2018/3/26.
 */
public interface CollegeMajorService {

    List<CollegeMajorModel> getColleges();
    List<CollegeMajorModel> getMajorsByCollegeEn(String collegeEn);
}
