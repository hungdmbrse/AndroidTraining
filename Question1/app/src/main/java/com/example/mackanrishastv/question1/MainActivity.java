package com.example.mackanrishastv.question1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isTrue = true;
        String str = "Question 1";
        int q1 = 24;
        double douQ1 = 24.26d;

        Log.d("Question1", String.valueOf(isTrue));
        Log.d("Question1", str);
        Log.d("Question1", String.valueOf(q1));
        Log.d("Question1", String.valueOf(douQ1));


    }
}
