package com.hiccs.arish.models;

/**
 * Created by AbdullahAtta on 4/20/2019.
 */
public class Suggestion {
    private String suggestBody;
    private String studentName;
    private String studentId;

    public Suggestion(String suggestBody, String studentName, String studentId) {
        this.suggestBody = suggestBody;
        this.studentName = studentName;
        this.studentId = studentId;
    }

    public String getSuggestBody() {
        return suggestBody;
    }

    public void setSuggestBody(String suggestBody) {
        this.suggestBody = suggestBody;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
