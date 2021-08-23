/*
 * Daily News
 *     AppInterceptor.java
 *     Created by Erwin Setiawan on 21/8/2021
 *     email 	    : heloowinn@gmail.com
 *     website 	: https://www.linkedin.com/in/helowin
 *     Copyright © 2021 Erwin Setiawan. All rights reserved.
 */

package com.example.network;

public class AppInterceptor {

    public static final String URL_API = "https://newsapi.org/";

    public static ApiService getApiService(){
        return ApiClient.getClient(URL_API).create(ApiService.class);
    }
}
