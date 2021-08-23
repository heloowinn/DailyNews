/*
 * Daily News
 *     ListNewsAdapter.java
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
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dailynews.DetailNewsActivity;
import com.example.dailynews.R;
import com.example.dailynews.Utils.Utils;
import com.example.model.ListNewsResponse;

import java.util.List;

public class ListNewsAdapter extends RecyclerView.Adapter<ListNewsAdapter.ViewHolder> {
    private Context context;
    private List<ListNewsResponse> listNews;

    public ListNewsAdapter(Context context, List<ListNewsResponse> listNews) {
        this.context = context;
        this.listNews = listNews;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListNewsAdapter.ViewHolder holder, int position) {
        final ListNewsResponse news = listNews.get(position);
        Glide.with(context).load(news.getImg()).into(holder.imageNews);
        holder.title.setText(news.getTitle());
        holder.date.setText(Utils.DateFormat(news.getDate()));
        if (news.getAuthoe() == null) {
            holder.publis.setText("Penulis Tidak Diketahui");
        } else {
            holder.publis.setText(news.getAuthoe());
        }

        holder.cvNews.setOnClickListener(v -> {
            context.startActivity(new Intent(context, DetailNewsActivity.class)
                    .putExtra(ListNewsResponse.class.getSimpleName(),listNews.get(position)));
        });

    }


    @Override
    public int getItemCount() {
        return listNews.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageNews;
        private TextView title, date, publis;
        private CardView cvNews;


        public ViewHolder(View view) {
            super(view);
            imageNews = itemView.findViewById(R.id.img_content);
            title = itemView.findViewById(R.id.tv_title);
            publis = itemView.findViewById(R.id.tv_penulis);
            date = itemView.findViewById(R.id.tv_date);
            cvNews = itemView.findViewById(R.id.cv_news);
        }
    }

}
