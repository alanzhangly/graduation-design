package com.design.controller;

import com.design.service.ManagerService;
import com.design.util.biz.CommonResponseModel;
import com.design.util.exception.GraduationDesignException;
import com.design.util.utils.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ke Zhang on 2018/3/20.
 *
 * 超级管理员控制层
 */
@RestController
@RequestMapping("/managers")
public class ManagerController {
    private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);
    @Autowired
    private ManagerService managerService;

    @RequestMapping("/login")
    public Object login(){

        return "login";
    }

    /**
     * 教师信息录入
     * @return
     */
    @PostMapping("/reg/teacher")
    public Object TeacherRegister(@RequestParam("file") MultipartFile file){
        Map result = new HashMap();
        try {
            int count = managerService.DoTeacherRegister(file);
            result.put("count", count);
        } catch (GraduationDesignException gde){
            LogUtil.error(logger, "get:{0},{1}",file,gde);
            return CommonResponseModel.facade(gde.getException_type());
        } catch (Exception e){
            LogUtil.error(logger, "get:{0},{1}",file,e);
            return CommonResponseModel.fail();
        }
        return CommonResponseModel.success(result);
    }

    /**
     * 学生信息录入
     * @return
     */
    @PostMapping("/reg/student")
    public Object StudentRegister(@RequestParam("file") MultipartFile file){
        Map result = new HashMap();
        try {
            int count = managerService.DoStudentRegister(file);
            result.put("count", count);
        } catch (GraduationDesignException gde){
            LogUtil.error(logger, "get:{0},{1}",file,gde);
            return CommonResponseModel.facade(gde.getException_type());
        } catch (Exception e){
            LogUtil.error(logger, "get:{0},{1}",file,e);
            return CommonResponseModel.fail();
        }
        return CommonResponseModel.success(result);
    }

    /**
     * 学院专业信息录入
     * @return
     */
    @PostMapping("/reg/cm")
    public Object CollegeMajorRegister(@RequestParam("file") MultipartFile file){
        Map result = new HashMap();
        try {
            int count = managerService.DoCollegeMajorRegister(file);
            result.put("count", count);
        } catch (GraduationDesignException gde){
            LogUtil.error(logger, "get:{0},{1}",file,gde);
            return CommonResponseModel.facade(gde.getException_type());
        } catch (Exception e){
            LogUtil.error(logger, "get:{0},{1}",file,e);
            return CommonResponseModel.fail();
        }
        return CommonResponseModel.success(result);
    }

    /**
     * 必修课信息录入
     * @return
     */
    @PostMapping("/reg/cs")
    public Object CourseSelectRegister(@RequestParam("file") MultipartFile file){
        Map result = new HashMap();
        try {
            int count = managerService.DoCourseSelectRegister(file);
            result.put("count", count);
        } catch (GraduationDesignException gde){
            LogUtil.error(logger, "get:{0},{1}",file,gde);
            return CommonResponseModel.facade(gde.getException_type());
        } catch (Exception e){
            LogUtil.error(logger, "get:{0},{1}",file,e);
            return CommonResponseModel.fail();
        }
        return CommonResponseModel.success(result);
    }
}
