package com.example.mackanrishastv.question16;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDialog(View view){
        FragmentManager fragmentManager = getFragmentManager();

        MyDialogFragment dialog = new MyDialogFragment();
        dialog.show(fragmentManager, "dialog");
    }
}
