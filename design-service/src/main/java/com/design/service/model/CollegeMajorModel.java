package com.design.service.model;

/**
 * Created by Ke Zhang on 2018/3/26.
 */
public class CollegeMajorModel {
    private String cmName;

    private String abbName;

    private String collegeEn;

    @Override
    public String toString() {
        return "CollegeMajorModel{" +
                "cmName='" + cmName + '\'' +
                ", abbName='" + abbName + '\'' +
                ", collegeEn='" + collegeEn + '\'' +
                '}';
    }

    public String getCmName() {
        return cmName;
    }

    public void setCmName(String cmName) {
        this.cmName = cmName;
    }

    public String getAbbName() {
        return abbName;
    }

    public void setAbbName(String abbName) {
        this.abbName = abbName;
    }

    public String getCollegeEn() {
        return collegeEn;
    }

    public void setCollegeEn(String collegeEn) {
        this.collegeEn = collegeEn;
    }
}
