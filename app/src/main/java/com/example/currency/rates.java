package com.example.currency;


import com.google.gson.annotations.SerializedName;

public class rates {

    private String name;
    private Float rate;

    public rates( ) {

    }

    public rates(String name , Float rate){
        this.name = name;
        this.rate = rate;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public Float getRate() {
        return rate;
    }
}
