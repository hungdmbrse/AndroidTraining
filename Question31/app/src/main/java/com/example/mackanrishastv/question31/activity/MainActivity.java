package com.example.mackanrishastv.question31.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.mackanrishastv.question31.R;
import com.example.mackanrishastv.question31.model.Forecast;
import com.example.mackanrishastv.question31.model.PostList;
import com.example.mackanrishastv.question31.rest.WeatherAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String url = "http://weather.livedoor.com/forecast/webservice/json/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherAPI weatherAPI = retrofit.create(WeatherAPI.class);
        Call<List<Forecast>> call = weatherAPI.findCityData(400040);

        call.enqueue(new Callback<List<Forecast>>() {
            @Override
            public void onResponse(Call<List<Forecast>> call, Response<List<Forecast>> response) {
                Log.e("Forecase :", response.body().get(0).getDateLabel().toString());
            }

            @Override
            public void onFailure(Call<List<Forecast>> call, Throwable t) {

            }
        });

    }


}
