package com.example.mackanrishastv.question48;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Hero> heroArrayList;
    DatabaseReference mData;
    HeroAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mData = FirebaseDatabase.getInstance().getReference();

        heroArrayList = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.rvAnimals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new HeroAdapter(this, heroArrayList);
        recyclerView.setAdapter(adapter);

//        heroArrayList.add(new Hero("Hulk", "Quan Sip khong bao gio rach"));
//        heroArrayList.add(new Hero("Thor", "Cuop bien chot mat"));
//        heroArrayList.add(new Hero("Iron Man", "Ban buon ve chai"));
//        heroArrayList.add(new Hero("Caption American", "Thanh nien phe thuoc"));

//        for(int i = 0; i < heroArrayList.size(); i++){
//            mData.child("Hero").push().setValue(heroArrayList.get(i));
//        }

        mData.child("Hero").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Hero hero = dataSnapshot.getValue(Hero.class);
                Toast.makeText(MainActivity.this, hero.getName(), Toast.LENGTH_SHORT).show();
                heroArrayList.add(new Hero(hero.getName(), hero.getDiscription()));
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mData.child("Hero").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Hero hero = dataSnapshot.getValue(Hero.class);
                heroArrayList.add(new Hero(hero.getName(), hero.getDiscription()));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
}
