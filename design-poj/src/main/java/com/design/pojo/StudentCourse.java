package com.design.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class StudentCourse implements Serializable {
    private String studentCourseId;

    private String scSudentId;

    private String scCourseId;

    private Date modifyTime;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public String getStudentCourseId() {
        return studentCourseId;
    }

    public void setStudentCourseId(String studentCourseId) {
        this.studentCourseId = studentCourseId;
    }

    public String getScSudentId() {
        return scSudentId;
    }

    public void setScSudentId(String scSudentId) {
        this.scSudentId = scSudentId;
    }

    public String getScCourseId() {
        return scCourseId;
    }

    public void setScCourseId(String scCourseId) {
        this.scCourseId = scCourseId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}