package com.example.currency;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Currencies {

    @SerializedName("success")
    private Boolean success;

    @SerializedName("base")
    private String base;

    @SerializedName("date")
    private String date;

    @SerializedName("timestamp")
    private Long timestamp;

    @SerializedName("rates")
    private Map<String, Double> rates;

    public Currencies() {
    }

    public Currencies(Boolean success, String base, String date, Long timestamp, Map<String, Double> rates){
        this.success = success;
        this.base = base;
        this.timestamp = timestamp;
        this.date = date;
        this.rates = rates;
    }
    public Boolean getSuccess() {
        return success;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }


    public Currencies getData() {
        Currencies currencies = new Currencies();

        /*for (int i = 0; i < currencies.rates.size(); i++) {
            if (data.getRates().get(i).getName() == "USD") {
                rates.add(currencies.getRates().get(i));
            }
            else if (data.getRates().get(i).getName() == "TRY"){
                rates.add(currencies.getRates().get(i));
            }
            else if (data.getRates().get(i).getName() == "BTC"){
                rates.add(currencies.getRates().get(i));
            }
        }*/
        currencies.setBase(this.getBase());

        return currencies;


    }
}


