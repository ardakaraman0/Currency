package com.example.currency;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class splash extends AppCompatActivity {

    private Retrofit retrofit = null;
    private Retrofit api = null;
    private String key = "d9a811d039072262ea05ebd824c96cfe";

    public boolean temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread timerThread = new Thread(){
        public void run(){
            try{
                sleep(3000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally{
                Intent intent = new Intent(splash.this, MainActivity.class);
                startActivity(intent);
            }
        }
    };
        timerThread.start();
    }

    private boolean checkAccessibility() {

        retrofit.newBuilder()
                .baseUrl("http://data.fixer.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final Call<Currencies> latest = api.create(ApiInterface.class).getLatest(key);

        latest.enqueue(new Callback<Currencies>() {
            @Override
            public void onResponse(Call<Currencies> call, Response<Currencies> response) {

                if (!response.isSuccessful()){
                    temp = false;
                    return;
                }
                temp = true;
            }
            @Override
            public void onFailure(Call<Currencies> call, Throwable t) {
                temp = false;
            }
        });

        return temp;
    };


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
