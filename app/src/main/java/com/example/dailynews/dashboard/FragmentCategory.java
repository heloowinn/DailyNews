/*
 * Daily News
 *     FragmentCategory.java
 *     Created by Erwin Setiawan on 21/8/2021
 *     email 	    : heloowinn@gmail.com
 *     website 	: https://www.linkedin.com/in/helowin
 *     Copyright © 2021 Erwin Setiawan. All rights reserved.
 */

package com.example.dailynews.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dailynews.ListNewsActivity;
import com.example.dailynews.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentCategory extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.category_fragment, container, false);
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    @OnClick (R.id.lin_eco) void onClickEco(){
        startActivity(new Intent(getActivity(), ListNewsActivity.class));
    }

    @OnClick (R.id.lin_bussines) void onClickBus(){
        startActivity(new Intent(getActivity(), ListNewsActivity.class));
    }

    @OnClick (R.id.lin_tec) void onClickTec(){
        startActivity(new Intent(getActivity(), ListNewsActivity.class));
    }

    @OnClick (R.id.lin_eco) void onClickEng(){
        startActivity(new Intent(getActivity(), ListNewsActivity.class));
    }

    @OnClick (R.id.lin_pol) void onClickPol(){
        startActivity(new Intent(getActivity(), ListNewsActivity.class));
    }

    @OnClick (R.id.lin_manual) void onClickManu(){
        startActivity(new Intent(getActivity(), ListNewsActivity.class));
    }

    @OnClick (R.id.lin_hel) void onClickHel(){
        startActivity(new Intent(getActivity(), ListNewsActivity.class));
    }

    @OnClick (R.id.lin_test) void onClickTest(){
        startActivity(new Intent(getActivity(), ListNewsActivity.class));
    }

}
