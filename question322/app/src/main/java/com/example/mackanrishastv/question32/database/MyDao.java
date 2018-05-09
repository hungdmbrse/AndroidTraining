package com.example.mackanrishastv.question32.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.mackanrishastv.question32.model.ForecastN;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    public void addForecaseN(ForecastN forecastN);

    @Query("SELECT * FROM forecastn")
    public List<ForecastN> getAllForecastN();

}
