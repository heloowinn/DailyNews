/*
 * Daily News
 *     FragmentHome.java
 *     Created by Erwin Setiawan on 21/8/2021
 *     email 	    : heloowinn@gmail.com
 *     website 	: https://www.linkedin.com/in/helowin
 *     Copyright © 2021 Erwin Setiawan. All rights reserved.
 */

package com.example.dailynews.dashboard;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.dailynews.BuildConfig;
import com.example.dailynews.DetailNewsActivity;
import com.example.dailynews.ListNewsActivity;
import com.example.dailynews.OnclickItemView;
import com.example.dailynews.R;
import com.example.dailynews.Utils.RXEdit;
import com.example.dailynews.dashboard.adapter.DashboardAdapter;
import com.example.dailynews.dashboard.adapter.MyPager;
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

public class FragmentHome extends Fragment {

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.rv_news)
    RecyclerView rvNews;

    @BindView(R.id.rv_news_favorit)
    RecyclerView rvNewsFavorite;

    @BindView(R.id.lin_dashboard)
    LinearLayout linDasboard;


    private DashboardAdapter dashboardAdapter;
    private MyPager myPager;
    List<ListNewsResponse> listNews = new ArrayList<>();
    ProgressDialog loading;
    ApiService api;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_fragment, container, false);
        ButterKnife.bind(this,rootView);
        api = AppInterceptor.getApiService();
        dashboardAdapter = new DashboardAdapter(getActivity(), listNews);


        rvNews.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvNews.setAdapter(dashboardAdapter);

        rvNewsFavorite.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rvNewsFavorite.setAdapter(dashboardAdapter);


        initDataBanner();
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void initDataBanner(){
        loading = new ProgressDialog(getActivity());
        loading.setCancelable(false);
        loading.setMessage("Loading..");
        showDialog();
        api.getListNews("id","business", BuildConfig.NEWS_API_TOKEN).enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful()){
                    hideDialog();

                    //Banner
                    listNews = response.body().getListNews();
                    myPager = new MyPager(getActivity(),listNews);
                    viewPager.setAdapter(myPager);

                    linDasboard.setVisibility(View.VISIBLE);

                    initConfig();

                } else {
                    hideDialog();
                    Toast.makeText(getActivity(), "Gagal memuat data !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                hideDialog();
                Toast.makeText(getActivity(), "Gagal menyambung ke internet !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initConfig() {
        api.getListAllNews("id", BuildConfig.NEWS_API_TOKEN).enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful()){
                    hideDialog();
                    initDataEverything();

                    //List News
                    listNews = response.body().getListNews();
                    rvNews.setAdapter(new DashboardAdapter(getActivity(), listNews));
                    dashboardAdapter.notifyDataSetChanged();

                } else {
                    Toast.makeText(getActivity(), "Gagal memuat data !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Gagal menyambung ke internet !", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void initDataEverything(){
        api.getEverythingNews("wsj.com", BuildConfig.NEWS_API_TOKEN).enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful()){
                    hideDialog();

                    listNews = response.body().getListNews();
                    rvNewsFavorite.setAdapter(new DashboardAdapter(getActivity(), listNews));
                    dashboardAdapter.notifyDataSetChanged();


                } else {
                    Toast.makeText(getActivity(), "Gagal memuat data !", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Gagal menyambung ke internet !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick (R.id.tv_see_all_headlines) void onClickHeadLine(){
        startActivity(new Intent(getActivity(), ListNewsActivity.class));
    }

    @OnClick (R.id.tv_see_all_favorit) void onClickFavorite(){
        startActivity(new Intent(getActivity(), ListNewsActivity.class));
    }

    @OnClick (R.id.tv_see_all_update) void onClickUpdate(){
        startActivity(new Intent(getActivity(), ListNewsActivity.class));
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
