package com.hiccs.arish.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentGrades {


    @SerializedName("StudentID")
    @Expose
    private String studentID;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("FullMark")
    @Expose
    private String fullMark;
    @SerializedName("Score")
    @Expose
    private String score;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullMark() {
        return fullMark;
    }

    public void setFullMark(String fullMark) {
        this.fullMark = fullMark;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

}