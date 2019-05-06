package com.hiccs.arish.models;

/**
 * Created by AbdullahAtta on 5/6/2019.
 */
public class SuggestionModel {
    private int studentId;
    private String suggestionContent;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getSuggestionContent() {
        return suggestionContent;
    }

    public void setSuggestionContent(String suggestionContent) {
        this.suggestionContent = suggestionContent;
    }
}
