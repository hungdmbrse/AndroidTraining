package com.example.mackanrishastv.question40;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final int READ_PERMISSION = 1000;
    private static int IMG_RESULT = 1;
    String ImageDecode;
    ImageView imageViewLoad;
    Button LoadImage;
    Intent intent;
    String[] FILE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewLoad = (ImageView) findViewById(R.id.imageView1);
        LoadImage = (Button)findViewById(R.id.button1);

        checkPermission();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean readStoragePermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;


        if (requestCode == READ_PERMISSION) {

            if (readStoragePermission) {
                getImage();
            } else {
                //許可なしで次の画面に移動されません。もう1回確認してお願い致します
                Toast.makeText(getApplicationContext(), "Unable to continue without permissions. ", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void checkPermission() {
        if (ContextCompat
                .checkSelfPermission(getApplicationContext(),
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission
                            .READ_EXTERNAL_STORAGE},
                    READ_PERMISSION);
        } else {

            getImage();
        }
    }

    private void getImage() {
        LoadImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(intent, IMG_RESULT);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {

            if (requestCode == IMG_RESULT && resultCode == RESULT_OK
                    && null != data) {


                Uri URI = data.getData();
                String[] FILE = { MediaStore.Images.Media.DATA };


                Cursor cursor = getContentResolver().query(URI,
                        FILE, null, null, null);

                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(FILE[0]);
                ImageDecode = cursor.getString(columnIndex);
                cursor.close();

                imageViewLoad.setImageBitmap(BitmapFactory
                        .decodeFile(ImageDecode));

            }
        } catch (Exception e) {
            Toast.makeText(this, "Please try again", Toast.LENGTH_LONG)
                    .show();
        }

    }
}