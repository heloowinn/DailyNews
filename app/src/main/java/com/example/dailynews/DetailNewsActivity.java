/*
 * Daily News
 *     DetailNewsActivity.java
 *     Created by Erwin Setiawan on 22/8/2021
 *     email 	    : heloowinn@gmail.com
 *     website 	: https://www.linkedin.com/in/helowin
 *     Copyright © 2021 Erwin Setiawan. All rights reserved.
 */

package com.example.dailynews;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.dailynews.Utils.Utils;
import com.example.model.ListNewsResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailNewsActivity extends AppCompatActivity {

    @BindView(R.id.tv_title) TextView tvTitle;
    @BindView(R.id.tv_publis) TextView tvPublis;
    @BindView(R.id.tv_date) TextView tvDate;
    @BindView(R.id.tv_content) TextView tvContent;
    @BindView(R.id.img_content)
    ImageView imgContent;
    @BindView(R.id.lin_preview)
    LinearLayout linView;

    private ListNewsResponse listNewsResponse;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);
        ButterKnife.bind(this);

        listNewsResponse = getIntent().getParcelableExtra(ListNewsResponse.class.getSimpleName());
        initData();
    }

    private void initData(){
        tvTitle.setText(listNewsResponse.getTitle());
        tvPublis.setText(listNewsResponse.getAuthoe());
        tvDate.setText(Utils.DateFormat(listNewsResponse.getDate()));
        tvContent.setText(listNewsResponse.getDescription());
        Glide.with(this)
                .load(listNewsResponse.getImg())
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imgContent);

        linView.setOnClickListener(v -> {
            String url = listNewsResponse.getLink();
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
    }

    @OnClick (R.id.img_share) void onShare(){
        String openUrl = listNewsResponse.getLink();

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, openUrl);
        startActivity(shareIntent);
    }

    @OnClick (R.id.img_back) void onBack(){
        onBackPressed();
    }

}
