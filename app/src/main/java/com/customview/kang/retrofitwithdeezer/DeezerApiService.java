package com.customview.kang.retrofitwithdeezer;

import com.customview.kang.retrofitwithdeezer.Domain.TrackData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by kang on 2017-04-05.
 */

public interface DeezerApiService {
    //http://api.deezer.com/search?q=track:"강남스타일"
    @GET("search")
    Call<TrackData> getData(@Query("q") String value);
}
