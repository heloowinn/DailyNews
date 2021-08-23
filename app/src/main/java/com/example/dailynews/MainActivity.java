/*
 * Daily News
 *     MainActivity.java
 *     Created by Erwin Setiawan on 21/8/2021
 *     email 	    : heloowinn@gmail.com
 *     website 	: https://www.linkedin.com/in/helowin
 *     Copyright © 2021 Erwin Setiawan. All rights reserved.
 */

package com.example.dailynews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dailynews.dashboard.FragmentCategory;
import com.example.dailynews.dashboard.FragmentHome;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.img_home) ImageView imgHome;
    @BindView(R.id.img_category) ImageView imgCategory;
    @BindView(R.id.tv_home) TextView tvHome;
    @BindView(R.id.tv_category) TextView tvCategory;

    private FragmentHome mFragmentHome = new FragmentHome();
    private FragmentCategory mFragmentCategory = new FragmentCategory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        onclickHome();

    }

    private void onSelected (int position){
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = mFragmentHome;
                break;
            case 1:
                fragment = mFragmentCategory;
                break;
        }
        if (fragment !=null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame_container,fragment)
                    .commit();
        }
    }

    private void clearTab(){
        imgHome.setImageResource(R.mipmap.ic_home);
        imgCategory.setImageResource(R.mipmap.ic_category);

        tvHome.setTextColor(Color.parseColor("#CECECE"));
        tvCategory.setTextColor(Color.parseColor("#CECECE"));
    }

    @OnClick (R.id.lin_home) void onclickHome(){
        clearTab();
        imgHome.setImageResource(R.mipmap.ic_home_active);
        tvHome.setTextColor(Color.parseColor("#37b7f0"));
        onSelected(0);
    }

    @OnClick (R.id.lin_category) void onClickCategory(){
        clearTab();
        imgCategory.setImageResource(R.mipmap.ic_category_active);
        tvCategory.setTextColor(Color.parseColor("#37b7f0"));
        onSelected(1);
    }

    @OnClick (R.id.fab) void onClickSearch(){
        startActivity(new Intent(this, SearchActivity.class));
    }

}