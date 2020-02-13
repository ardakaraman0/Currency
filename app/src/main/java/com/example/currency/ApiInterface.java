package com.example.currency;

import android.database.Observable;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/latest")
    Call<Currencies> getLatest(@Query("access_key") String key);

    @GET("symbols")
    Call<Currencies> getSymbols(@Query("access_key") String key);

    @GET("convert")
    Call<Currencies> convert(@Query("access_key") String key, @Query("from") String from, @Query("to") String to,
                             @Query("amount") Integer amount, @Query("date") String date);

    @GET("fluctuation")
    Call<Currencies> fluctuation(@Query("access_key") String key, @Query("start-date") String start, @Query("end-date") String end);



}