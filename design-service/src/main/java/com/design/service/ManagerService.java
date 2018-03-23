package com.design.service;

import org.springframework.web.multipart.MultipartFile;


/**
 * Created by Ke Zhang on 2018/3/21.
 */
public interface ManagerService {

    int DoCourseSelectRegister(MultipartFile file);
    int DoCollegeMajorRegister(MultipartFile file);
    int DoStudentRegister(MultipartFile file);
    int DoTeacherRegister(MultipartFile file);
}
