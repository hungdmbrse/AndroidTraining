package com.example.mackanrishastv.question18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void initView(){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<DataRecly> arrayList = new ArrayList<>();
        arrayList.add((new DataRecly(R.drawable.fb, "Facebook")));
        arrayList.add((new DataRecly(R.drawable.go, "Goolgle")));
        arrayList.add((new DataRecly(R.drawable.inst, "Instagram")));
        arrayList.add((new DataRecly(R.drawable.twiter, "Twister")));
        arrayList.add((new DataRecly(R.drawable.wo, "WordPress")));
        arrayList.add((new DataRecly(R.drawable.you, "Youtube")));

        DataAdapter dataAdapter = new DataAdapter(arrayList, getApplicationContext());
        recyclerView.setAdapter(dataAdapter);


    }
}
