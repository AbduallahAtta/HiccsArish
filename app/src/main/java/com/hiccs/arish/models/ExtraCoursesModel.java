package com.hiccs.arish.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExtraCoursesModel {


    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("courseName")
    @Expose
    private String courseName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("imgUrl")
    @Expose
    private String imgUrl;
    @SerializedName("necessary")
    @Expose
    private String necessary;
    @SerializedName("periodTime")
    @Expose
    private String periodTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getNecessary() {
        return necessary;
    }

    public void setNecessary(String necessary) {
        this.necessary = necessary;
    }

    public String getPeriodTime() {
        return periodTime;
    }

    public void setPeriodTime(String periodTime) {
        this.periodTime = periodTime;
    }

}