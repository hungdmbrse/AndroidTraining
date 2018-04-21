package com.example.mackanrishastv.question1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean bool = true;
        boolean ibool = false;

        Log.d("ManhHung", String.valueOf(bool) + " - " + String.valueOf(ibool));

        int temp = 24;
        double temp1 = 24.654d;
        String temp2 = "研修";

        Log.d("ManhHung", "Int = " + temp);
        Log.d("ManhHung", "Double = " + temp1);
        Log.d("ManhHung", "String = " + temp2);

    }
}
