package com.hiccs.arish.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StaffModel implements Parcelable {
    public static final Creator<StaffModel> CREATOR = new Creator<StaffModel>() {
        @Override
        public StaffModel createFromParcel(Parcel in) {
            return new StaffModel(in);
        }

        @Override
        public StaffModel[] newArray(int size) {
            return new StaffModel[size];
        }
    };
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("drName")
    @Expose
    private String drName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("imgUrl")
    @Expose
    private String imgUrl;

    public StaffModel(Parcel in) {
        id = in.readString();
        drName = in.readString();
        description = in.readString();
        imgUrl = in.readString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDrName() {
        return drName;
    }

    public void setDrName(String drName) {
        this.drName = drName;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(drName);
        dest.writeString(description);
        dest.writeString(imgUrl);

    }
}