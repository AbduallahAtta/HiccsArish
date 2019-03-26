package com.hiccs.arish.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GradesModel {
    @SerializedName("stu_id")
    @Expose
    private String stuId;
    @SerializedName("cou_id")
    @Expose
    private String couId;
    @SerializedName("degrees")
    @Expose
    private String degrees;
    @SerializedName("grade")
    @Expose
    private String grade;

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getCouId() {
        return couId;
    }

    public void setCouId(String couId) {
        this.couId = couId;
    }

    public String getDegrees() {
        return degrees;
    }

    public void setDegrees(String degrees) {
        this.degrees = degrees;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}
