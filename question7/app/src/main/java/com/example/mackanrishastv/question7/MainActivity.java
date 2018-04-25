package com.example.mackanrishastv.question7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Math math = new Math();
        math.calculate(new Result() {
            @Override
            public void result(int resultValue) {
                Log.d("Callback", String.valueOf(resultValue));
            }
        });

    }
}
