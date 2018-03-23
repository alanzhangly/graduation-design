package com.design.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class CollegeMajorInfo implements Serializable {
    private String cmId;

    private Integer flag;

    private String cmName;

    private String abbName;

    private String collegeEn;

    private Integer status;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public String getCmId() {
        return cmId;
    }

    public void setCmId(String cmId) {
        this.cmId = cmId;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCollegeEn() {
        return collegeEn;
    }

    public void setCollegeEn(String collegeEn) {
        this.collegeEn = collegeEn;
    }
}