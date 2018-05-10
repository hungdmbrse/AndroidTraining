package com.example.mackanrishastv.question38;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    static final int REQUEST_CAPTURE_IMAGE = 100;

    Button button1;
    ImageView imageView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListeners();
    }

    protected void findViews(){
        button1 = (Button)findViewById(R.id.button1);
        imageView1 = (ImageView)findViewById(R.id.imageView1);
    }

    protected void setListeners(){
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(
                        intent,
                        REQUEST_CAPTURE_IMAGE);
            }
        });
    }

    @Override
    protected void onActivityResult(
            int requestCode,
            int resultCode,
            Intent data) {
        if(REQUEST_CAPTURE_IMAGE == requestCode
                && resultCode == Activity.RESULT_OK ){
            Bitmap capturedImage =
                    (Bitmap) data.getExtras().get("data");
            imageView1.setImageBitmap(capturedImage);
        }
    }
}
