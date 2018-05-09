package com.example.mackanrishastv.question32.rest;



import com.example.mackanrishastv.question32.model.PostList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {
    @GET("v1")
    Call<PostList> findCityData(@Query("city") int idCity);
}
