package com.example.mackanrishastv.question45;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private static final int GET_LOCATION = 1280;
    private GPSChecker gpsChecker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.txtViewLocation);

        checkPermission();



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        boolean locationFinePermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
        boolean locationCoarsePermission = grantResults[1] == PackageManager.PERMISSION_GRANTED;


        if (requestCode == GET_LOCATION) {
            //if(grantResults[1] == PackageManager.PERMISSION_GRANTED){
            if (locationFinePermission && locationCoarsePermission) {

                gpsChecker = new GPSChecker(this);
                double latitude = gpsChecker.getLatitude();
                double longgitude = gpsChecker.getLongitude();
                textView.setText("Latitude : " + latitude + " Longtitude * " + longgitude);
            } else {
                //許可なしで次の画面に移動されません。もう1回確認してお願い致します
                Toast.makeText(getApplicationContext(), "Unable to continue without permissions. ", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void checkPermission() {
        if (ContextCompat
                        .checkSelfPermission(getApplicationContext(),
                                Manifest.permission.ACCESS_FINE_LOCATION) +
                        +ContextCompat
                                .checkSelfPermission(getApplicationContext(),
                                        Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    GET_LOCATION);
        } else {

            gpsChecker = new GPSChecker(this);
            double latitude = gpsChecker.getLatitude();
            double longgitude = gpsChecker.getLongitude();
            textView.setText("Latitude : " + latitude + " Longtitude * " + longgitude);
        }
    }

}
