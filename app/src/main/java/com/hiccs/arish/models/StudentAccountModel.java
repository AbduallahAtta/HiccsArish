package com.hiccs.arish.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentAccountModel {


    @SerializedName("StudentID")
    @Expose
    private String studentID;
    @SerializedName("FullName")
    @Expose
    private String fullName;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("Phone")
    @Expose
    private String phone;
    @SerializedName("ImgUrl")
    @Expose
    private String imgUrl;
    @SerializedName("Department_Name")
    @Expose
    private String departmentName;
    @SerializedName("academic_year_num")
    @Expose
    private String academicYearNum;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getAcademicYearNum() {
        return academicYearNum;
    }

    public void setAcademicYearNum(String academicYearNum) {
        this.academicYearNum = academicYearNum;
    }

}