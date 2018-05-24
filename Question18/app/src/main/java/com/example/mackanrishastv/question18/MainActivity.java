package com.example.mackanrishastv.question18;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView(){

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<SocialNetwork> socialNetworkArrayList = new ArrayList<>();
        socialNetworkArrayList.add(new SocialNetwork("Facebook", R.drawable.fb));
        socialNetworkArrayList.add(new SocialNetwork("Google", R.drawable.go));
        socialNetworkArrayList.add(new SocialNetwork("Instagram", R.drawable.inst));
        socialNetworkArrayList.add(new SocialNetwork("Email", R.drawable.mail));
        socialNetworkArrayList.add(new SocialNetwork("Twitter", R.drawable.twiter));
        socialNetworkArrayList.add(new SocialNetwork("Word Press", R.drawable.wo));

        Toast.makeText(this, "dasd", Toast.LENGTH_SHORT).show();
        SocialNetworkAdapter socialNetworkAdapter = new SocialNetworkAdapter(socialNetworkArrayList, getApplicationContext());
        recyclerView.setAdapter(socialNetworkAdapter);


    }
}
