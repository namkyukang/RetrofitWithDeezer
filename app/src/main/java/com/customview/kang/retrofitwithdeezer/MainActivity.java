package com.customview.kang.retrofitwithdeezer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    TextView txtResult;
    RetrofitDeezerUtil deezerUtil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity","=====================================================0");
        initWidget();

        Log.d("MainActivity","=====================================================1");
        deezerUtil = new RetrofitDeezerUtil();
        Log.d("MainActivity","=====================================================2");
        deezerUtil.setRetrofit();
        Log.d("MainActivity","=====================================================3");
        btnSearch.setOnClickListener(listener);
    }
    public void initWidget(){
        editTrack = (EditText)findViewById(R.id.editTrack);
        btnSearch = (Button)findViewById(R.id.btnSearch);
        txtResult = (TextView)findViewById(R.id.txtData);

    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("MainActivity","Button On Click==========================================editTrack : " + editTrack.getText().toString());
            txtResult.setText( deezerUtil.searchTrack(editTrack.getText().toString()) );
        }
    };
}
