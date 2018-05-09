package com.example.mackanrishastv.question32.activity;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.mackanrishastv.question32.R;
import com.example.mackanrishastv.question32.adapter.ForecastAdapter;
import com.example.mackanrishastv.question32.database.MyAppDatabase;
import com.example.mackanrishastv.question32.model.Forecast;
import com.example.mackanrishastv.question32.model.ForecastN;
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
    private  static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        forecastArrayList = new ArrayList<>();
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "forecastdb").allowMainThreadQueries().build();

        final int[] forecastID = {getMaxId()};

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

                    ForecastN forecastNTemp = new ForecastN();
                    forecastNTemp.setId(forecastID[0]);
                    forecastNTemp.setDataLabel(forecastArrayList.get(i).getDateLabel());
                    forecastNTemp.setTelop(forecastArrayList.get(i).getTelop());
                    forecastNTemp.setDate(forecastArrayList.get(i).getDate());
                    if(forecastArrayList.get(i).getTemperature().getMin() != null)
                    {
                        forecastNTemp.setMin(forecastArrayList.get(i).getTemperature().getMin().getCelsius());
                    } else
                    {
                        forecastNTemp.setMin("??");
                    }

                    if(forecastArrayList.get(i).getTemperature().getMax() != null)
                    {
                        forecastNTemp.setMax(forecastArrayList.get(i).getTemperature().getMax().getCelsius() );
                    } else
                    {
                        forecastNTemp.setMax("??");
                    }

                    forecastNTemp.setImage(forecastArrayList.get(i).getImage().getUrl());

                    myAppDatabase.myDao().addForecaseN(forecastNTemp);
                    forecastID[0]++;

                }


                initView(forecastArrayList);
            }

            @Override
            public void onFailure(Call<PostList> call, Throwable t) {

            }
        });


        readDB();

    }

    public void readDB()
    {
        ArrayList<ForecastN> forecastNArrayList = (ArrayList<ForecastN>) myAppDatabase.myDao().getAllForecastN();
        for(ForecastN forecastN : forecastNArrayList)
        {
            Log.d("ReadDB", "ID :" + forecastN.getId() + "Datelabel : " + forecastN.getDataLabel() + " , Telop : "
                    + forecastN.getTelop() + " , Date: " + forecastN.getDate() + " , Min : "
                    + forecastN.getMin() + ", Max : " + forecastN.getMax() + ", Image : "
                    + forecastN.getImage());
        }
    }

    public int getMaxId(){
        ArrayList<ForecastN> forecastNArrayList = (ArrayList<ForecastN>) myAppDatabase.myDao().getAllForecastN();
        return forecastNArrayList.size();
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
