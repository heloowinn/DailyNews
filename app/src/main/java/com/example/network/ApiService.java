/*
 * Daily News
 *     ApiService.java
 *     Created by Erwin Setiawan on 21/8/2021
 *     email 	    : heloowinn@gmail.com
 *     website 	: https://www.linkedin.com/in/helowin
 *     Copyright © 2021 Erwin Setiawan. All rights reserved.
 */

package com.example.network;

import com.example.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/v2/top-headlines")
    Call<NewsResponse> getListNews(@Query("country") String country, @Query("category") String category, @Query("apiKey") String apiKey);

    @GET("/v2/top-headlines")
    Call<NewsResponse> getListAllNews(@Query("country") String country, @Query("apiKey") String apiKey);

    @GET("/v2/everything")
    Call<NewsResponse> getEverythingNews(@Query("domains") String domains, @Query("apiKey") String apiKey);

    @GET("/v2/everything")
    Call<NewsResponse> getSearch(@Query("q") String domains, @Query("apiKey") String apiKey);

}
