package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.JsonObject;

import java.io.Console;
import java.io.IOException;
import java.util.Date;

import butterknife.BindString;
import butterknife.*;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private Unbinder unbinder;

    private static String key = "d9a811d039072262ea05ebd824c96cfe";
    private static String URL = "http://data.fixer.io/api/";

    private Retrofit retrofit;
    private Retrofit api;

    private Response<Currencies> wait;

    public Currencies data;
    public Currencies adaptedData;
    public Date date;

    //@BindView(R.id.base) TextView base;
    TextView base = (TextView) findViewById(R.id.base);

    @BindView(R.id.rate1) TextView rate1;
    @BindView(R.id.rate2) TextView rate2;
    @BindView(R.id.rate3) TextView rate3;
    @BindView(R.id.rateRes1) TextView rateRes1;
    @BindView(R.id.rateRes2) TextView rateRes2;
    @BindView(R.id.rateRes3) TextView rateRes3;
    @BindView(R.id.time) TextView time;




    Runnable updater;
    void updateTimer(){

        final Handler timerHandler = new Handler();
        updater = new Runnable() {
            @Override
            public void run() {
                getJson();
                timerHandler.postDelayed(updater,2000);
            }
        };
    }



    public void getJson(){
        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Call<Currencies> latest = retrofit.create(ApiInterface.class).getLatest(key);
        latest.enqueue(new Callback<Currencies>() {
            @Override
            public void onResponse(Call<Currencies> call, Response<Currencies> response) {
                if (!response.isSuccessful()){
                    Log.d("Call", "There is a response but it is not a shit.");
                    return;
                }
                data = response.body();
            }
            @Override
            public void onFailure(Call<Currencies> call, Throwable t) {
                Log.d("Call", "There is no response.");
                return;
            }
        });

    }


    public void setData() {
        if (data != null){
        adaptedData = data.getData();

        this.base.setText(data.getBase());
        /*
        this.rate1.setText(adaptedData.getRates().get(0).getName());
        this.rate2.setText(adaptedData.getRates().get(1).getName());
        this.rate3.setText(adaptedData.getRates().get(2).getName());

        this.rateRes1.setText(adaptedData.getRates().get(0).getRate().toString());
        this.rateRes2.setText(adaptedData.getRates().get(1).getRate().toString());
        this.rateRes3.setText(adaptedData.getRates().get(2).getRate().toString());
*/}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Call<Currencies> latest = retrofit.create(ApiInterface.class).getLatest(key);
        latest.enqueue(new Callback<Currencies>() {
            @Override
            public void onResponse(Call<Currencies> call, Response<Currencies> response) {
                if (!response.isSuccessful()){
                    return;
                }
                wait = response;
                data = response.body();
            }
            @Override
            public void onFailure(Call<Currencies> call, Throwable t) {
                Log.d("Call", "There is no response.");
                return;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        setData();
    }
}
