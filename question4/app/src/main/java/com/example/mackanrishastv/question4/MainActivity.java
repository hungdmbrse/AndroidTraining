package com.example.mackanrishastv.question4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Account acc1 = new Account("ManhHung", 23, "Male", "Japanese");
        Account acc2 = new Account("HoangHoa", 26, "Male", "English");
        Account acc3 = new Account("ThucTrinh", 24, "Female", "Franch");

        acc1.showAccount();
        acc2.showAccount();
        acc3.showAccount();

    }
}
