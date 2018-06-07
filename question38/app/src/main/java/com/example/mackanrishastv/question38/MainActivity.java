package com.example.mackanrishastv.question38;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final int RESULT_CAMERA = 1001;
    private static final int PERMISSION_CODE = 1280;
    private ImageView imageView;

    private Uri cameraUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.captured_photo);
        Button button = (Button) findViewById(R.id.photo_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermission();
            }
        });
    }

    private void openCamera() {
        String filename = System.currentTimeMillis() + ".jpg";
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, filename);
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
        cameraUri = getContentResolver().insert(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, cameraUri);
        startActivityForResult(intent, RESULT_CAMERA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULT_CAMERA) {
            try {
                Bitmap image = MediaStore.Images.Media.getBitmap(this.getContentResolver(), cameraUri);
                int width = image.getWidth();
                int height = image.getHeight();

                Bitmap bitmap = Bitmap.createBitmap(image, 0, 0, width, height, null, false);

                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                Log.e("System.err", e.getMessage());
            }
        }
    }

    public void checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                + ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
            openCamera();
        }
        else {
            requestPermission();
        }
    }

    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE},
                        PERMISSION_CODE);
            }

        } else {
            Toast.makeText(this, "Don't have permisson to action", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean cameraPermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
        boolean readStoragePermission = grantResults[1] == PackageManager.PERMISSION_GRANTED;

        if (requestCode == PERMISSION_CODE) {
            if (cameraPermission && readStoragePermission) {
                openCamera();
            } else {
                Toast.makeText(getApplicationContext(), "Unable to continue without permissions. ", Toast.LENGTH_LONG).show();
            }
        }
    }

    private String getFilePath(Uri uri) {
        String[] projection = {MediaStore.MediaColumns.DATA};
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {
            String path = null;
            if (cursor.moveToFirst()) {
                path = cursor.getString(0);
            }
            cursor.close();
            if (path != null) {
                return path;
            }
        }
        return null;
    }

}