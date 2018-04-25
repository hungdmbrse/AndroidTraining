package com.example.mackanrishastv.question24;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    Button btnDown;
    ImageView imageView;
    String URL = "https://pbs.twimg.com/profile_images/801907324302610436/l_i7uBsE_400x400.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDown = (Button) findViewById(R.id.button_down);
        imageView = (ImageView) findViewById(R.id.image);

        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadTask downloadTask = new DownloadTask();
                downloadTask.execute(URL);

            }
        });
    }

        class DownloadTask extends AsyncTask<String, Integer, String>{

            ProgressDialog progressDialog;

            @Override
            protected void onProgressUpdate(Integer... values) {
                progressDialog.setProgress(values[0]);
            }

            @Override
            protected String doInBackground(String... voids) {
                String path = voids[0];
                int file_length = 0;
                try {
                    java.net.URL url = new URL(path);
                    URLConnection urlConnection = url.openConnection();
                    urlConnection.connect();
                    file_length = urlConnection.getContentLength();
                    File new_folder = new File("sdcard/photo");
                    if(!new_folder.exists()){
                        new_folder.mkdir();
                    }

                    File input_file = new File(new_folder, "download_image.jpg");
                    InputStream inputStream = new BufferedInputStream(url.openStream(), 8192);
                    byte[] data = new byte[1024];
                    int total = 0;
                    int count = 0;
                    OutputStream outputStream = new FileOutputStream(input_file);
                    while((count = inputStream.read(data))!= -1){
                        total +=count;
                        outputStream.write(data,0,count);
                        int progress = (int) total*100/file_length;
                        publishProgress(progress);
                    }

                    inputStream.close();
                    outputStream.close();


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return "Download Complete";
            }

            @Override
            protected void onPreExecute() {
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("Download in processing...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setMax(100);
                progressDialog.setProgress(0);
                progressDialog.show();
            }

            @Override
            protected void onPostExecute(String aVoid) {
                progressDialog.hide();

                Toast.makeText(getApplicationContext(), aVoid, Toast.LENGTH_LONG).show();

                String path = "sdcard/photo/download_image.jpg";
                imageView.setImageDrawable(Drawable.createFromPath(path));
            }
        }
}
