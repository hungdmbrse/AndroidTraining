
package com.example.mackanrishastv.question31.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forecast {

    @SerializedName("dateLabel")
    @Expose
    private String dateLabel;
    @SerializedName("telop")
    @Expose
    private String telop;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("temperature")
    @Expose
    private Temperature temperature;
    @SerializedName("image")
    @Expose
    private Image image;

    public String getDateLabel() {
        return dateLabel;
    }

    public void setDateLabel(String dateLabel) {
        this.dateLabel = dateLabel;
    }

    public String getTelop() {
        return telop;
    }

    public void setTelop(String telop) {
        this.telop = telop;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

}
