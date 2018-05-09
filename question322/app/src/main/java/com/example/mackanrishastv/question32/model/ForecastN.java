package com.example.mackanrishastv.question32.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "forecastn")
public class ForecastN {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataLabel() {
        return dataLabel;
    }

    public void setDataLabel(String dataLabel) {
        this.dataLabel = dataLabel;
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

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "data_label")
    private String dataLabel;

    @ColumnInfo(name = "telop")
    private String telop;

    @ColumnInfo(name = "date")
    private String date;

    @ColumnInfo(name = "min")
    private String min;

    @ColumnInfo(name = "max")
    private String max;

    @ColumnInfo(name = "image")
    private String image;




}
