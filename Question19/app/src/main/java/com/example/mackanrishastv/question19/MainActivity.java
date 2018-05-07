package com.example.mackanrishastv.question19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<SocialNetwork> socialNetworkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        socialNetworkList = new ArrayList<>();
        socialNetworkList.add(new SocialNetwork("Facebook", R.drawable.fb));
        socialNetworkList.add(new SocialNetwork("Google", R.drawable.go));
        socialNetworkList.add(new SocialNetwork("Instagram", R.drawable.inst));
        socialNetworkList.add(new SocialNetwork("Email", R.drawable.mail));
        socialNetworkList.add(new SocialNetwork("Twitter", R.drawable.twiter));
        socialNetworkList.add(new SocialNetwork("Word Press", R.drawable.wo));
        socialNetworkList.add(new SocialNetwork("Twitter", R.drawable.twiter));
        socialNetworkList.add(new SocialNetwork("Word Press", R.drawable.wo));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, socialNetworkList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}
