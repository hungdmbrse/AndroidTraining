package com.example.mackanrishastv.question20;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vpSmile;
    private ArrayList<Face> lstFace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        lstFace = new ArrayList<>();
        lstFace.add(new Face("#ff00", R.drawable.fb, "Facebook"));
        lstFace.add(new Face("#f0", R.drawable.go, "Google"));
        lstFace.add(new Face("#f00", R.drawable.inst, "Instagram"));
        lstFace.add(new Face("#ff0", R.drawable.you, "youtube"));

    }

    private void initView() {
        vpSmile = (ViewPager) findViewById(R.id.vp_smile);
        myAdapter myAdapterVar = new myAdapter(this, lstFace);
    }
}
