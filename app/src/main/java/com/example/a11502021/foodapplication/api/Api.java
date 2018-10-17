package com.example.a11502021.foodapplication.api;

import com.example.a11502021.foodapplication.models.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 11502021 on 9/10/2018.
 */

public interface Api {

    String BASE_URL = "https://api.edamam.com";
    String APP_ID = "0ddbef04";
    String APP_KEY = "5b5829870f140360800ce3af3a6b6781";

    @GET("search")
    Call<Example> getHits(@Query("q") String keyword, @Query("app_id") String app_id, @Query("app_key") String app_key);

}
