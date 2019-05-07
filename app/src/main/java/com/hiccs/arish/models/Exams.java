package com.hiccs.arish.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by AbdullahAtta on 5/7/2019.
 */
public class Exams implements Parcelable {
    public static final Creator<Exams> CREATOR = new Creator<Exams>() {
        @Override
        public Exams createFromParcel(Parcel in) {
            return new Exams(in);
        }

        @Override
        public Exams[] newArray(int size) {
            return new Exams[size];
        }
    };
    private ArrayList<String> exams;

    public Exams() {
    }

    public Exams(ArrayList<String> exams) {
        this.exams = exams;
    }

    protected Exams(Parcel in) {
        exams = in.createStringArrayList();
    }

    public ArrayList<String> getExams() {
        return exams;
    }

    public void setExams(ArrayList<String> exams) {
        this.exams = exams;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(exams);
    }
}
