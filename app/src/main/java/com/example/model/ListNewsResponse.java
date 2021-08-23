/*
 * Daily News
 *     ListNewsResponse.java
 *     Created by Erwin Setiawan on 21/8/2021
 *     email 	    : heloowinn@gmail.com
 *     website 	: https://www.linkedin.com/in/helowin
 *     Copyright © 2021 Erwin Setiawan. All rights reserved.
 */

package com.example.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ListNewsResponse implements Parcelable {

    @SerializedName("title")
    String title;
    @SerializedName("publishedAt")
    String date;
    @SerializedName("author")
    String authoe;
    @SerializedName("description")
    String description;
    @SerializedName("url")
    String link;
    @SerializedName("urlToImage")
    String img;


    public ListNewsResponse(String title, String date, String authoe, String description, String link, String img) {
        this.title = title;
        this.date = date;
        this.authoe = authoe;
        this.description = description;
        this.link = link;
        this.img = img;
    }

    protected ListNewsResponse(Parcel in) {
        title = in.readString();
        date = in.readString();
        authoe = in.readString();
        description = in.readString();
        link = in.readString();
        img = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(date);
        dest.writeString(authoe);
        dest.writeString(description);
        dest.writeString(link);
        dest.writeString(img);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ListNewsResponse> CREATOR = new Creator<ListNewsResponse>() {
        @Override
        public ListNewsResponse createFromParcel(Parcel in) {
            return new ListNewsResponse(in);
        }

        @Override
        public ListNewsResponse[] newArray(int size) {
            return new ListNewsResponse[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthoe() {
        return authoe;
    }

    public void setAuthoe(String authoe) {
        this.authoe = authoe;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
