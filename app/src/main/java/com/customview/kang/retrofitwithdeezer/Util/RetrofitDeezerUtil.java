package com.customview.kang.retrofitwithdeezer.Util;

import android.util.Log;

import com.customview.kang.retrofitwithdeezer.DeezerApiService;
import com.customview.kang.retrofitwithdeezer.Domain.API_URL;
import com.customview.kang.retrofitwithdeezer.Domain.Data;
import com.customview.kang.retrofitwithdeezer.Domain.TrackData;
import com.customview.kang.retrofitwithdeezer.Domain.artist;
import com.customview.kang.retrofitwithdeezer.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kang on 2017-04-05.
 */

public class RetrofitDeezerUtil {

    Retrofit retrofit;
    DeezerApiService service;
    String json = "";


    public void setRetrofit() {
        //레트로 핏을 생성하고
        //http://api.deezer.com/search?q=track:"강남스타일"

        retrofit = new Retrofit.Builder()
                .baseUrl(API_URL.deezer_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //사용할 인터페이스를 설정한다
        service = retrofit.create(DeezerApiService.class);
        //데이터를 가져온다

    }

    public String searchTrack(String value){
        value = "track:\""+value+"\"";
        Log.d("MainRetroDeezerUnit","searchTrack ===============================================value : " + value);
        Call<TrackData> result = service.getData(value);

        result.enqueue(new Callback<TrackData>() {
            @Override
            public void onResponse(Call<TrackData> call, Response<TrackData> response) {
                if(response.isSuccessful()) {
                    Log.d("MainRetrofitDeezer",response.body().toString());
                    TrackData trackData = response.body();
                    //json = response.body().toString();
                    for(Data data : trackData.getData()){
                        Log.d("Artist","=============artist : " + data.getArtist().getName());
                    }

                }else{
                    Log.d("MainRetrofit",response.message());   //정상적이지 않을경우 message에 오류 내용이 담겨온다.
                }
            }

            @Override
            public void onFailure(Call<TrackData> call, Throwable t) {
                //통신 자체가 잘못됐을 경우 이쪽으로 넘어온다.
                Log.d("MainRetrofit","Failure===========================================");   //정상적이지 않을경우 message에 오류 내용이 담겨온다.
            }
        });
        return json;
    }
}
