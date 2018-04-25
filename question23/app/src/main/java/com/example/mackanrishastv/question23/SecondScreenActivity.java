package com.example.mackanrishastv.question23;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;
import android.widget.TextView;


public class SecondScreenActivity extends Activity {

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        textView = (TextView) findViewById(R.id.acc2_textView);

        Intent i = getIntent();

        String str = i.getStringExtra("str");

        textView.setText(str);
    }
}
