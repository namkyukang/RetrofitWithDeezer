package com.customview.kang.retrofitwithdeezer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.customview.kang.retrofitwithdeezer.Domain.TrackData;
import com.customview.kang.retrofitwithdeezer.Util.RetrofitDeezerUtil;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText editTrack;
    Button btnSearch;
    RetrofitDeezerUtil deezerUtil;
    View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidget();
        deezerUtil = new RetrofitDeezerUtil();
        deezerUtil.setRetrofit();
        editTrack.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public void initWidget(){
        editTrack = (EditText)findViewById(R.id.editTrack);
        btnSearch = (Button)findViewById(R.id.btnSearch);

    }

}
