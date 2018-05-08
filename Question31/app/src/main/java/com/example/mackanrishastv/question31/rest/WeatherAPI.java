package com.example.mackanrishastv.question31.rest;


import com.example.mackanrishastv.question31.model.Forecast;
import com.example.mackanrishastv.question31.model.PostList;


import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {
    @GET("v1")
    Call<List<Forecast>> findCityData(@Query("city") int idCity);
}
