package com.hiccs.arish.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by AbdullahAtta on 4/9/2019.
 */
public class Student {
    @SerializedName("StudentID")
    @Expose
    private String studentID;
    @SerializedName("StudentUserName")
    @Expose
    private String studentUserName;
    @SerializedName("StudentPassword")
    @Expose
    private String studentPassword;
    @SerializedName("FullName")
    @Expose
    private String fullName;
    @SerializedName("ImgUrl")
    @Expose
    private String imgUrl;
    @SerializedName("Phone")
    @Expose
    private String phone;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("AcademicYear")
    @Expose
    private String academicYear;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentUserName() {
        return studentUserName;
    }

    public void setStudentUserName(String studentUserName) {
        this.studentUserName = studentUserName;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

}
