package com.zhadko.gifdisplayingtest.network;

import com.zhadko.gifdisplayingtest.models.Data;
import com.zhadko.gifdisplayingtest.models.Gif;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestInterface {
    @GET("v1/gifs/trending")
    Call<Data> getGifList(@Query("api_key") String api_key);
}
