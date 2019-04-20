package com.hiccs.arish.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by AbdullahAtta on 2/19/2019.
 */
public class GalleryImages implements Parcelable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("imgUrl")
    @Expose
    private String imgUrl;

    protected GalleryImages(Parcel in) {
        id = in.readString();
        imgUrl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(imgUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GalleryImages> CREATOR = new Creator<GalleryImages>() {
        @Override
        public GalleryImages createFromParcel(Parcel in) {
            return new GalleryImages(in);
        }

        @Override
        public GalleryImages[] newArray(int size) {
            return new GalleryImages[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}


