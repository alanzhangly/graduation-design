package com.design.controller;

import com.design.pojo.CollegeMajorInfo;
import com.design.service.CollegeMajorService;
import com.design.service.model.CollegeMajorModel;
import com.design.util.biz.CommonResponseModel;
import com.design.util.exception.GraduationDesignException;
import com.design.util.utils.BeanUtil;
import com.design.util.utils.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ke Zhang on 2018/3/26.
 * 学院专业信息
 */
@RestController
@RequestMapping("/cm")
public class CollegeMajorController {

    private static final Logger logger = LoggerFactory.getLogger(CollegeMajorController.class);
    @Autowired
    private CollegeMajorService collegeMajorService;

    /**
     * 获取所有学院信息
     * @return
     */
    @GetMapping("/getColleges")
    public Object getColleges(){
        Map result = new HashMap();
        try {
            List<CollegeMajorModel> collegeInfos = collegeMajorService.getColleges();
            result.put("data", collegeInfos);
            return CommonResponseModel.success(result);
        } catch (GraduationDesignException gde){
            LogUtil.error(logger, "get:{0}",gde);
            return CommonResponseModel.facade(gde.getException_type());
        } catch (Exception e){
            LogUtil.error(logger, "get:{0}",e);
            return CommonResponseModel.fail();
        }
    }

    /**
     * 根据学院英文获取专业信息列表
     * @param collegeEn
     * @return
     */
    @PostMapping("/getMajors")
    public Object getMajors(@RequestParam(value = "college_en") String collegeEn){
        Map result = new HashMap();
        try {
            List<CollegeMajorModel> list = collegeMajorService.getMajorsByCollegeEn(collegeEn);
            result.put("data", list);
            return CommonResponseModel.success(result);
        } catch (GraduationDesignException gde){
            LogUtil.error(logger, "get:{0},{1}",collegeEn, gde);
            return CommonResponseModel.facade(gde.getException_type());
        } catch (Exception e){
            LogUtil.error(logger, "get:{0},{1}",collegeEn, e);
            return CommonResponseModel.fail();
        }
    }
}
