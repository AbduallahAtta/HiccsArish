package com.hiccs.arish.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExtraCoursesModel implements Parcelable {
    public static final Creator<ExtraCoursesModel> CREATOR = new Creator<ExtraCoursesModel>() {
        @Override
        public ExtraCoursesModel createFromParcel(Parcel in) {
            return new ExtraCoursesModel(in);
        }

        @Override
        public ExtraCoursesModel[] newArray(int size) {
            return new ExtraCoursesModel[size];
        }
    };
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

    public ExtraCoursesModel(Parcel in) {
        id = in.readString();
        courseName = in.readString();
        description = in.readString();
        imgUrl = in.readString();

    }

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

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(courseName);
        dest.writeString(description);
        dest.writeString(imgUrl);

    }
}