package com.example.mackanrishastv.question32.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.mackanrishastv.question32.R;
import com.example.mackanrishastv.question32.adapter.ForecastAdapter;
import com.example.mackanrishastv.question32.model.Forecast;
import com.example.mackanrishastv.question32.model.PostList;
import com.example.mackanrishastv.question32.rest.WeatherAPI;
import com.master.glideimageview.GlideImageView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private  static ArrayList<Forecast> forecastArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        forecastArrayList = new ArrayList<>();

        final String url = "http://weather.livedoor.com/forecast/webservice/json/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherAPI weatherAPI = retrofit.create(WeatherAPI.class);
        Call<PostList> call = weatherAPI.findCityData(400040);

        call.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(Call<PostList> call, Response<PostList> response) {
                forecastArrayList = (ArrayList<Forecast>) response.body().getForecasts();
                for (int i = 0; i < MainActivity.forecastArrayList.size(); i++) {
                    Log.d("Weather", "天気情報　： " + MainActivity.forecastArrayList.get(i).getDateLabel()
                            + " : " + "Telop :" + MainActivity.forecastArrayList.get(i).getTelop() + ", Date : "
                            + MainActivity.forecastArrayList.get(i).getDate());
                }
                initView(forecastArrayList);
            }

            @Override
            public void onFailure(Call<PostList> call, Throwable t) {

            }
        });

    }

    private void initView(ArrayList<Forecast> forecastArrayList) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.activity_RecyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ForecastAdapter forecastAdapter = new ForecastAdapter(forecastArrayList, getApplicationContext());
        recyclerView.setAdapter(forecastAdapter);
    }

}
