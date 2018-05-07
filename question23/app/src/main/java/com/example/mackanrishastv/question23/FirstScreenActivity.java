package com.example.mackanrishastv.question23;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstScreenActivity extends AppCompatActivity {


    EditText editText;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

        editText = (EditText) findViewById(R.id.acc1_editText);
        btnSend = (Button) findViewById(R.id.acc1_button);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondScreenActivity.class);

                intent.putExtra("str", editText.getText().toString());

                startActivity(intent);
            }
        });

    }
}
