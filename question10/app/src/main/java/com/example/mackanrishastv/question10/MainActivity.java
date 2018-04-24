package com.example.mackanrishastv.question10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private HashMap hm;
    private ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = (ImageView) findViewById(R.id.imageView);
        Button btn = (Button) findViewById(R.id.button);

        hm = new HashMap();
        hm.put(0, R.drawable.fb );
        hm.put(1, R.drawable.firefox);
        hm.put(2, R.drawable.mail);
        hm.put(3, R.drawable.twitter);
        hm.put(4, R.drawable.youtube);

        btn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage();
            }

        });


    }

    private void showImage(){
        Random random = new Random();
        int imgNum = random.nextInt(5);

        int rSourceImage = (int) hm.get(imgNum);

        imgView.setImageResource(rSourceImage);

    }
}
