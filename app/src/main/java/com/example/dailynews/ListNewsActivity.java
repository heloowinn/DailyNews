/*
 * Daily News
 *     ListNewsActivity.java
 *     Created by Erwin Setiawan on 22/8/2021
 *     email 	    : heloowinn@gmail.com
 *     website 	: https://www.linkedin.com/in/helowin
 *     Copyright © 2021 Erwin Setiawan. All rights reserved.
 */

package com.example.dailynews;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dailynews.dashboard.adapter.ListNewsAdapter;
import com.example.model.ListNewsResponse;
import com.example.model.NewsResponse;
import com.example.network.ApiService;
import com.example.network.AppInterceptor;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListNewsActivity extends AppCompatActivity {

    @BindView(R.id.rv_list_news)
    RecyclerView rvListNews;

    private ListNewsAdapter listNewsAdapter;
    List<ListNewsResponse> listNews = new ArrayList<>();
    ProgressDialog loading;
    ApiService api;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);
        ButterKnife.bind(this);

        api = AppInterceptor.getApiService();
        listNewsAdapter = new ListNewsAdapter(this, listNews);
        rvListNews.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvListNews.setAdapter(listNewsAdapter);

        initDataBanner();
    }

    private void initDataBanner(){
        loading = new ProgressDialog(this);
        loading.setCancelable(false);
        loading.setMessage("Loading..");
        showDialog();
        api.getListAllNews("id", BuildConfig.NEWS_API_TOKEN).enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful()){
                    hideDialog();

                    //Banner
                    listNews = response.body().getListNews();
                    rvListNews.setAdapter(new ListNewsAdapter(ListNewsActivity.this, listNews));
                    listNewsAdapter = new ListNewsAdapter(ListNewsActivity.this, listNews);
                    listNewsAdapter.notifyDataSetChanged();

                } else {
                    hideDialog();
                    Toast.makeText(ListNewsActivity.this, "Gagal memuat data !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                hideDialog();
                Toast.makeText(ListNewsActivity.this, "Gagal menyambung ke internet !", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @OnClick (R.id.img_back) void onBack(){
        onBackPressed();
    }

    private void showDialog() {
        if (!loading.isShowing())
            loading.show();
    }

    private void hideDialog() {
        if (loading.isShowing())
            loading.dismiss();
    }

}
