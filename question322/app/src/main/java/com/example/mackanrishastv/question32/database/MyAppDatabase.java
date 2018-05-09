package com.example.mackanrishastv.question32.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.mackanrishastv.question32.model.ForecastN;

@Database(entities = {ForecastN.class}, version = 1)
public abstract class MyAppDatabase extends RoomDatabase {

    public abstract MyDao myDao();
}
