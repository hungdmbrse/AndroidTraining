package com.example.mackanrishastv.question25;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Todo> arrayListTodo;
    private DatabaseAccess databaseAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        databaseAccess.addTodo("Get up early", "6 am", "2018/5/8", "", "2018/5/30");
        databaseAccess.addTodo("Shopping", "rice", "2018/5/8", "", "2018/5/9");
        databaseAccess.addTodo("Learn", "english", "2018/5/8", "", "2018/5/30");
        databaseAccess.addTodo("Party", "shinjuku", "2018/5/8", "", "2018/5/10");

        ArrayList<Todo> todoArrayList = new ArrayList<>();
        todoArrayList = databaseAccess.getListTodo();
        for(Todo todo: todoArrayList)
        {
            Log.d("ReadDB","Id : " + todo.getTodo_id() + " , Title :" + todo.getTodo_title());

        }

        databaseAccess.close();



    }
}
