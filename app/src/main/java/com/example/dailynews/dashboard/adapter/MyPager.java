/*
 * Daily News
 *     MyPager.java
 *     Created by Erwin Setiawan on 22/8/2021
 *     email 	    : heloowinn@gmail.com
 *     website 	: https://www.linkedin.com/in/helowin
 *     Copyright © 2021 Erwin Setiawan. All rights reserved.
 */

package com.example.dailynews.dashboard.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.dailynews.DetailNewsActivity;
import com.example.dailynews.R;
import com.example.model.ListNewsResponse;

import java.util.List;

public class MyPager extends PagerAdapter {

    private Context context;
    private List<ListNewsResponse> listNews;

    public MyPager(Context context, List<ListNewsResponse> listNews) {
        this.context = context;
        this.listNews = listNews;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_banner, null);
        ImageView imageView = view.findViewById(R.id.image);
        TextView tvTitle = view.findViewById(R.id.tv_title);

        Glide.with(context)
                .load(listNews.get(position).getImg())
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageView);

        if (listNews.get(position).getTitle() != null) {
            tvTitle.setText(listNews.get(position).getTitle());
        } else {
            tvTitle.setText("-");
        }

        view.setOnClickListener(v -> {
            context.startActivity(new Intent(context, DetailNewsActivity.class)
                    .putExtra(ListNewsResponse.class.getSimpleName(),listNews.get(position)));
        });

        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return listNews.size() > 4 ? 4 : listNews.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return object == view;
    }
}
