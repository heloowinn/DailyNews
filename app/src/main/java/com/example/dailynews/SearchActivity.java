/*
 * Daily News
 *     SearchActivity.java
 *     Created by Erwin Setiawan on 23/8/2021
 *     email 	    : heloowinn@gmail.com
 *     website 	: https://www.linkedin.com/in/helowin
 *     Copyright © 2021 Erwin Setiawan. All rights reserved.
 */

package com.example.dailynews;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dailynews.Utils.RXEdit;
import com.example.dailynews.dashboard.adapter.ListNewsAdapter;
import com.example.model.ListNewsResponse;
import com.example.model.NewsResponse;
import com.example.network.ApiService;
import com.example.network.AppInterceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.rv_search)
    RecyclerView rvSearch;

    @BindView(R.id.inp_search)
    EditText inpSearch;

    private ListNewsAdapter listNewsAdapter;
    List<ListNewsResponse> listNews = new ArrayList<>();
    ProgressDialog loading;
    private String search;
    ApiService api;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        api = AppInterceptor.getApiService();
        listNewsAdapter = new ListNewsAdapter(this, listNews);
        rvSearch.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvSearch.setAdapter(listNewsAdapter);

        RXEdit.bind(inpSearch)
                .debounce(300, TimeUnit.MILLISECONDS)
                .filter(s -> s.length() >= 0)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    search = inpSearch.getText().toString();
                    searchNews(s);
                });
    }

    private void searchNews(String search) {
        loading = new ProgressDialog(this);
        loading.setCancelable(false);
        loading.setMessage("Loading..");
        showDialog();
        api.getSearch(search, BuildConfig.NEWS_API_TOKEN).enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful()) {
                    hideDialog();

                    //List News
                    listNews = response.body().getListNews();
                    rvSearch.setAdapter(new ListNewsAdapter(SearchActivity.this, listNews));
                    listNewsAdapter.notifyDataSetChanged();


                } else {
                    hideDialog();

                    listNews.clear();
                    listNewsAdapter.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(), "Gagal memuat data !", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                hideDialog();
                Toast.makeText(getApplicationContext(), "Gagal menyambung ke internet !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showDialog() {
        if (!loading.isShowing())
            loading.show();
    }

    private void hideDialog() {
        if (loading.isShowing())
            loading.dismiss();
    }

    @OnClick (R.id.img_back) void onBack(){
        onBackPressed();
    }

}
