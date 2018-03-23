package com.design.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ke Zhang on 2018/3/22.
 */
public class StudentCourseModel implements Serializable{
    private String id;
    private String studentId;
    private String courseId;


    @Override
    public String toString() {
        return "StudentCourseModel{" +
                "id='" + id + '\'' +
                ", studentId='" + studentId + '\'' +
                ", courseId='" + courseId + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

}
