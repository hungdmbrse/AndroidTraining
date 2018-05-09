package com.example.mackanrishastv.question32.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Max {

    public String getCelsius() {
        return celsius;
    }

    public void setCelsius(String celsius) {
        this.celsius = celsius;
    }

    public String getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(String fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    @SerializedName("celsius")
    @Expose
    private String celsius;
    @SerializedName("fahrenheit")
    @Expose
    private String fahrenheit;
}
