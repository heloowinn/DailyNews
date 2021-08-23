/*
 * Daily News
 *     SplashActivity.java
 *     Created by Erwin Setiawan on 21/8/2021
 *     email 	    : heloowinn@gmail.com
 *     website 	: https://www.linkedin.com/in/helowin
 *     Copyright © 2021 Erwin Setiawan. All rights reserved.
 */

package com.example.dailynews;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static int splashInterval = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                this.finish();
            }

            private void finish() {
                // TODO Auto-generated method stub

            }
        }, splashInterval);

    }


}
