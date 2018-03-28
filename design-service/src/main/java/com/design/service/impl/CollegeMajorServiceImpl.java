package com.design.service.impl;

import com.design.dao.CollegeMajorInfoMapper;
import com.design.pojo.CollegeMajorInfo;
import com.design.service.CollegeMajorService;
import com.design.service.model.CollegeMajorModel;
import com.design.util.annotaion.LogAuto;
import com.design.util.exception.GraduationDesignException;
import com.design.util.exception.ReturnCodeModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ke Zhang on 2018/3/26.
 */
@Service
public class CollegeMajorServiceImpl implements CollegeMajorService {

    @Autowired
    private CollegeMajorInfoMapper collegeMajorInfoMapper;

    @Override
    @LogAuto
    public List<CollegeMajorModel> getColleges() {
        List<CollegeMajorInfo> list = collegeMajorInfoMapper.selectAllColleges();
        if(list == null){
            return null;
        }
        List<CollegeMajorModel> result = new ArrayList<>(list.size());
        for(CollegeMajorInfo info : list){
            CollegeMajorModel model = new CollegeMajorModel();
            BeanUtils.copyProperties(info, model);
            result.add(model);
        }
        return result;
    }

    @Override
    @LogAuto
    public List<CollegeMajorModel> getMajorsByCollegeEn(String collegeEn) {
        if(StringUtils.isEmpty(collegeEn)){
            throw new GraduationDesignException(ReturnCodeModel.PARAMETER_MISS);
        }
        List<CollegeMajorInfo> list = collegeMajorInfoMapper.selectMajorsByCollegeEn(collegeEn);
        if(list == null){
            return null;
        }
        List<CollegeMajorModel> result = new ArrayList<>(list.size());
        for(CollegeMajorInfo info : list){
            CollegeMajorModel model = new CollegeMajorModel();
            BeanUtils.copyProperties(info, model);
            result.add(model);
        }
        return result;
    }
}
