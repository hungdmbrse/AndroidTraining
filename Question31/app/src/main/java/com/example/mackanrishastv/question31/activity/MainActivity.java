package com.example.mackanrishastv.question31.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mackanrishastv.question31.R;
import com.example.mackanrishastv.question31.model.Forecast;
import com.example.mackanrishastv.question31.model.PostList;
import com.example.mackanrishastv.question31.rest.WeatherAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnToday, btnTomorrow, btnTheDayAfterTomorrow;
    ArrayList<Forecast> forecastArrayList;

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
        Call<PostList> call = weatherAPI.findCityData(400040);

        call.enqueue(new Callback<PostList>() {
            @Override
            public void onResponse(Call<PostList> call, Response<PostList> response) {
                forecastArrayList = (ArrayList<Forecast>) response.body().getForecasts();
                for(int i = 0; i < forecastArrayList.size(); i++){
                    Log.d("Weather","天気情報　： " + forecastArrayList.get(i).getDateLabel()
                    +  " : " + "Telop :" + forecastArrayList.get(i).getTelop() + ", Date : "
                    + forecastArrayList.get(i).getDate());
                }
            }

            @Override
            public void onFailure(Call<PostList> call, Throwable t) {

            }
        });

        btnToday = (Button) findViewById(R.id.btnToday);
        btnTomorrow = (Button) findViewById(R.id.btnTomorrow);
        btnTheDayAfterTomorrow = (Button) findViewById(R.id.btnTheDayAfterTomorrow);

        btnToday.setOnClickListener(this);
        btnTomorrow.setOnClickListener(this);
        btnTheDayAfterTomorrow.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnToday:
                showChangeLangDialog(forecastArrayList.get(0), "today");
                break;
            case R.id.btnTomorrow:
                showChangeLangDialog(forecastArrayList.get(1), "tomorrow");
                break;
            case R.id.btnTheDayAfterTomorrow:
                showChangeLangDialog(forecastArrayList.get(2), "thedayaftertomorrow");
                break;
        }
    }

    public void showChangeLangDialog(Forecast forecast, String day) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_weather_3days, null);
        dialogBuilder.setView(dialogView);

        TextView txtViewDay = (TextView) dialogView.findViewById(R.id.txtViewDay);
        TextView txtViewDate = (TextView) dialogView.findViewById(R.id.txtViewDate);
        TextView txtViewTelop = (TextView) dialogView.findViewById(R.id.txtViewTelop);
        TextView txtViewMin = (TextView) dialogView.findViewById(R.id.txtViewMin);
        TextView txtViewMax = (TextView) dialogView.findViewById(R.id.txtViewMax);

        switch (day){
            case "today":
                txtViewDay.setText("今日");
                break;
            case "tomorrow":
                txtViewDay.setText("明日");
                break;
            case "thedayaftertomorrow":
                txtViewDay.setText("明後日");
                break;
        }

        txtViewDate.setText(forecast.getDate());
        txtViewTelop.setText(forecast.getTelop());
        if(forecast.getTemperature().getMin() != null) {
            txtViewMin.setText(forecast.getTemperature().getMin().toString());
        } else {
            txtViewMin.setText("まだ");
        }
        if(forecast.getTemperature().getMax() != null) {
            txtViewMax.setText(forecast.getTemperature().getMax().toString());
        } else {
            txtViewMax.setText("まだ");
        }
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }
}
