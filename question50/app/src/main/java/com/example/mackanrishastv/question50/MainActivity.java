package com.example.mackanrishastv.question50;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtViewCaption, txtViewComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtViewCaption = (TextView) findViewById(R.id.txtViewCaption);
        txtViewComment = (TextView) findViewById(R.id.txtViewComment);

        Intent intent = getIntent();
        String action = intent.getAction();

        if (Intent.ACTION_VIEW.equals(action)) {
            Uri uri = intent.getData();
            if (uri != null) {
                String param1 = uri.getQueryParameter("caption");
                String param2 = uri.getQueryParameter("comment");
                txtViewCaption.setText(param1);
                txtViewComment.setText(param2);
            }
        }
    }
}
