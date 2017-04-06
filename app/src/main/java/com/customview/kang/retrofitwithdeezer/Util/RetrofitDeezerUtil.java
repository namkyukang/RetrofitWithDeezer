package com.customview.kang.retrofitwithdeezer.Util;

import android.util.Log;
import android.widget.TextView;

import com.customview.kang.retrofitwithdeezer.DeezerApiService;
import com.customview.kang.retrofitwithdeezer.Domain.API_URL;
import com.customview.kang.retrofitwithdeezer.Domain.Data;
import com.customview.kang.retrofitwithdeezer.Domain.Needs;
import com.customview.kang.retrofitwithdeezer.Domain.TrackData;
import com.customview.kang.retrofitwithdeezer.Domain.artist;
import com.customview.kang.retrofitwithdeezer.MainActivity;

import java.util.ArrayList;
import java.util.List;

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

    public List<Needs> searchTrack(String value){
        value = "track:\""+value+"\"";
        Call<TrackData> result = service.getData(value);
        final List<Needs> datas = new ArrayList<>();

        result.enqueue(new Callback<TrackData>() {
            @Override
            public void onResponse(Call<TrackData> call, Response<TrackData> response) {
                if(response.isSuccessful()) {
                    TrackData trackData = response.body();
                    //json = response.body().toString();
                    for(Data data : trackData.getData()){
                        Needs needs = new Needs();

                        needs.setArtist(data.getArtist().getName());
                        needs.setTitle(data.getTitle());
                        needs.setAlbum(data.getAlbum().getTitle());
                        needs.setImage(data.getAlbum().getCover());
                        needs.setDuration(data.getDuration());
                        needs.setPreview(data.getPreview());
                        needs.setAlbumList(data.getAlbum().getTracklist());
                        datas.add(needs);
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
        return datas;
    }
}
