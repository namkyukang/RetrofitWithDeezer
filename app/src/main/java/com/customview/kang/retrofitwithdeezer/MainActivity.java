package com.customview.kang.retrofitwithdeezer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.customview.kang.retrofitwithdeezer.Domain.Needs;
import com.customview.kang.retrofitwithdeezer.Domain.TrackData;
import com.customview.kang.retrofitwithdeezer.Util.RetrofitDeezerUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText editTrack;
    Button btnSearch;
    RetrofitDeezerUtil deezerUtil;
    View view;
    List<Needs> datas;
    RecyclerView recyclerView;

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
                datas = deezerUtil.searchTrack(editTrack.getText().toString());
                RecyclerViewAdpt adapater = new RecyclerViewAdpt(MainActivity.this, datas);
                LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);

                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(adapater);

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
        recyclerView = (RecyclerView)findViewById(R.id.Search_result);

    }

}
