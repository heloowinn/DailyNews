/*
 * Daily News
 *     NewsResponse.java
 *     Created by Erwin Setiawan on 21/8/2021
 *     email 	    : heloowinn@gmail.com
 *     website 	: https://www.linkedin.com/in/helowin
 *     Copyright © 2021 Erwin Setiawan. All rights reserved.
 */

package com.example.model;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsResponse{

    @SerializedName("status")
    private String status;

    @SerializedName("totalResults")
    private String totalResults;

    @SerializedName("articles")
    private List<ListNewsResponse> listNews;

    public NewsResponse(Context context, List<ListNewsResponse> listNews) {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public List<ListNewsResponse> getListNews() {
        return listNews;
    }

    public void setListNews(List<ListNewsResponse> listNews) {
        this.listNews = listNews;
    }
}
