/*
 * Daily News
 *     RXEdit.java
 *     Created by Erwin Setiawan on 23/8/2021
 *     email 	    : heloowinn@gmail.com
 *     website 	: https://www.linkedin.com/in/helowin
 *     Copyright © 2021 Erwin Setiawan. All rights reserved.
 */

package com.example.dailynews.Utils;

import io.reactivex.Observable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class RXEdit {

    public static Observable<String> bind(AutoCompleteTextView editText) {

        return Observable.create(subscriber -> {

            TextWatcher textWatcher = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                    subscriber.onNext(String.valueOf(s));
                }
            };

            editText.addTextChangedListener(textWatcher);

        });
    }

    public static Observable<String> bind(EditText editText) {

        return Observable.create(subscriber -> {

            TextWatcher textWatcher = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                    subscriber.onNext(String.valueOf(s));
                }
            };

            editText.addTextChangedListener(textWatcher);

        });
    }
}
