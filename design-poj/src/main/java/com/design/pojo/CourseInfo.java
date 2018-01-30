package com.design.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class CourseInfo implements Serializable {
    private String courseId;

    private String courseName;

    private String teacherName;

    private String weeklyStudyTime;

    private String weeklyStartEnd;

    private Float credits;

    private String classTime;

    private String classPlace;

    private Integer totalStudyTime;

    private Integer classroomStudyTime;

    private Integer experimentStudyTime;

    private Integer computerStudyTime;

    private Integer studentCount;

    private String classNature;

    private String inspectionWay;

    private String studyYear;

    private Integer semester;

    private Date modifyTime;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getWeeklyStudyTime() {
        return weeklyStudyTime;
    }

    public void setWeeklyStudyTime(String weeklyStudyTime) {
        this.weeklyStudyTime = weeklyStudyTime;
    }

    public String getWeeklyStartEnd() {
        return weeklyStartEnd;
    }

    public void setWeeklyStartEnd(String weeklyStartEnd) {
        this.weeklyStartEnd = weeklyStartEnd;
    }

    public Float getCredits() {
        return credits;
    }

    public void setCredits(Float credits) {
        this.credits = credits;
    }

    public String getClassTime() {
        return classTime;
    }

    public void setClassTime(String classTime) {
        this.classTime = classTime;
    }

    public String getClassPlace() {
        return classPlace;
    }

    public void setClassPlace(String classPlace) {
        this.classPlace = classPlace;
    }

    public Integer getTotalStudyTime() {
        return totalStudyTime;
    }

    public void setTotalStudyTime(Integer totalStudyTime) {
        this.totalStudyTime = totalStudyTime;
    }

    public Integer getClassroomStudyTime() {
        return classroomStudyTime;
    }

    public void setClassroomStudyTime(Integer classroomStudyTime) {
        this.classroomStudyTime = classroomStudyTime;
    }

    public Integer getExperimentStudyTime() {
        return experimentStudyTime;
    }

    public void setExperimentStudyTime(Integer experimentStudyTime) {
        this.experimentStudyTime = experimentStudyTime;
    }

    public Integer getComputerStudyTime() {
        return computerStudyTime;
    }

    public void setComputerStudyTime(Integer computerStudyTime) {
        this.computerStudyTime = computerStudyTime;
    }

    public Integer getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
    }

    public String getClassNature() {
        return classNature;
    }

    public void setClassNature(String classNature) {
        this.classNature = classNature;
    }

    public String getInspectionWay() {
        return inspectionWay;
    }

    public void setInspectionWay(String inspectionWay) {
        this.inspectionWay = inspectionWay;
    }

    public String getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(String studyYear) {
        this.studyYear = studyYear;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
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